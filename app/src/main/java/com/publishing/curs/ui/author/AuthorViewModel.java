package com.publishing.curs.ui.author;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.data.catalog.mappers.AuthorMapper;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.ui.base.BaseViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AuthorViewModel extends BaseViewModel {
    private final MutableLiveData<AuthorModel> authorLiveData;

    private final BooksDao booksDao = App.getInstance().getDatabase().booksDao();

    public AuthorViewModel() {
        authorLiveData = new MutableLiveData<>();
    }

    public void loadAuthorDetails(long authorId) {
        track(
                booksDao.getAuthor(authorId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                        .subscribe(authorEntity -> {
                            authorLiveData.setValue(AuthorMapper.toAuthorModel(authorEntity));
                        }, throwable -> {
                            errorLiveData.setValue(throwable.getLocalizedMessage());
                        })
        );
    }

    public LiveData<AuthorModel> getAuthor() {
        return authorLiveData;
    }
}
