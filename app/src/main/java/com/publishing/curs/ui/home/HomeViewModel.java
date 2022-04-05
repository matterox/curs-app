package com.publishing.curs.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.data.catalog.BannerModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.HeaderModel;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.database.entities.relation.BookWithAuthors;
import com.publishing.curs.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel {

    private final MutableLiveData<List<BaseCatalogModel>> homeLiveData;
    private final MutableLiveData<BookModel> openBookLiveData;

    private List<BaseCatalogModel> homeModels = new ArrayList<>();
    private BooksDao booksDao = App.getInstance().getDatabase().booksDao();

    public HomeViewModel() {
        homeLiveData = new MutableLiveData<>();
        openBookLiveData = new MutableLiveData<>();
        updateHome();
    }

    public void updateHome() {
        track(booksDao.getBestBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> homeModels.clear())
                .doOnEvent((event, error) -> refreshingLiveData.setValue(false))
                .subscribe(booksWithAuthors -> {
                    homeModels.add(new BannerModel("https://covers.openlibrary.org/w/id/10408030-M.jpg"));
                    homeModels.add(new HeaderModel("Bestsellers"));
                    for (BookWithAuthors bookWithAuthors : booksWithAuthors) {
                        homeModels.add(BookWithAuthors.toBookModel(bookWithAuthors));
                    }
                    homeLiveData.setValue(homeModels);
                }, throwable -> {
                    errorLiveData.setValue(throwable.getLocalizedMessage());
                }));
    }

    public void bookClicked(BookModel bookModel) {
        openBookLiveData.setValue(bookModel);
    }

    public LiveData<List<BaseCatalogModel>> getHomeModels() {
        return homeLiveData;
    }

    public LiveData<BookModel> getOpenBook() {
        return openBookLiveData;
    }
}