package com.publishing.curs.ui.booksample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.ui.base.BaseViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BookSampleViewModel extends BaseViewModel {
    private final MutableLiveData<String> bookUrlLiveData;

    public BookSampleViewModel() {
        bookUrlLiveData = new MutableLiveData<>();
    }

    private final BooksDao booksDao = App.getInstance().getDatabase().booksDao();

    public void loadBook(Long bookId) {
        track(booksDao.getBook(bookId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> refreshingLiveData.setValue(true))
                .doOnEvent((event, error) -> refreshingLiveData.setValue(false))
                .subscribe(
                        bookEntity -> bookUrlLiveData.setValue("https://mozilla.github.io/pdf.js/legacy/web/viewer.html?file=" + bookEntity.snippetUrl),
                        throwable -> errorLiveData.setValue(throwable.getLocalizedMessage())
                ));
    }

    public LiveData<String> getBookUrl() {
        return bookUrlLiveData;
    }
}
