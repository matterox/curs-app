package com.publishing.curs.ui.authors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.data.catalog.mappers.AuthorMapper;
import com.publishing.curs.data.catalog.mappers.BookWithAuthorsMapper;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AuthorsViewModel extends BaseViewModel {
    private final MutableLiveData<List<BaseCatalogModel>> authorsLiveData;
    private final MutableLiveData<AuthorModel> openAuthorLiveData;

    private final List<BaseCatalogModel> catalogModels = new ArrayList<>();
    private final BooksDao booksDao = App.getInstance().getDatabase().booksDao();

    public AuthorsViewModel() {
        authorsLiveData = new MutableLiveData<>();
        openAuthorLiveData = new MutableLiveData<>();
        updateAuthors();
    }

    public void updateAuthors() {
        track(booksDao.getAuthors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> {
                    refreshingLiveData.setValue(true);
                    catalogModels.clear();
                })
                .doOnEvent((event, error) -> refreshingLiveData.setValue(false))
                .subscribe(authorEntities -> {
                    for (AuthorEntity authorEntity : authorEntities) {
                        catalogModels.add(AuthorMapper.toAuthorModel(authorEntity));
                    }
                    authorsLiveData.setValue(catalogModels);
                }, throwable -> errorLiveData.setValue(throwable.getLocalizedMessage())));
    }

    public void authorClicked(AuthorModel bookModel) {
        openAuthorLiveData.setValue(bookModel);
    }

    public LiveData<List<BaseCatalogModel>> getAutnorsModels() {
        return authorsLiveData;
    }

    public LiveData<AuthorModel> getOpenAuthor() {
        return openAuthorLiveData;
    }
}
