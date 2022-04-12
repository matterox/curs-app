package com.publishing.curs.ui.catalog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.HeaderModel;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.database.entities.relation.BookWithAuthors;
import com.publishing.curs.database.entities.CategoryEntity;
import com.publishing.curs.database.entities.relation.CategoryWithBooksAndAuthors;
import com.publishing.curs.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CatalogViewModel extends BaseViewModel {

    private final MutableLiveData<List<BaseCatalogModel>> catalogLiveData;
    private final MutableLiveData<BookModel> openBookLiveData;

    private final List<BaseCatalogModel> catalogModels = new ArrayList<>();
    private final BooksDao booksDao = App.getInstance().getDatabase().booksDao();

    public CatalogViewModel() {
        catalogLiveData = new MutableLiveData<>();
        openBookLiveData = new MutableLiveData<>();
        updateCatalog();
    }

    public void updateCatalog() {
        track(booksDao.getAllBooksAndCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> {
                    refreshingLiveData.setValue(true);
                    catalogModels.clear();
                })
                .doOnEvent((event, error) -> refreshingLiveData.setValue(false))
                .subscribe(categoriesWithBooksAndAuthors -> {
                    for (CategoryWithBooksAndAuthors categoryWithBooksAndAuthors : categoriesWithBooksAndAuthors) {
                        CategoryEntity categoryEntity = categoryWithBooksAndAuthors.category;
                        List<BookWithAuthors> booksWithAuthors = categoryWithBooksAndAuthors.booksWithAuthors;
                        catalogModels.add(new HeaderModel(categoryEntity.titleRus));
                        for (BookWithAuthors bookWithAuthors : booksWithAuthors) {
                            catalogModels.add(BookWithAuthors.toBookModel(bookWithAuthors));
                        }
                    }
                    catalogLiveData.setValue(catalogModels);
                }, throwable -> {
                    errorLiveData.setValue(throwable.getLocalizedMessage());
                }));
    }

    public void bookClicked(BookModel bookModel) {
        openBookLiveData.setValue(bookModel);
    }

    public LiveData<List<BaseCatalogModel>> getCatalogModels() {
        return catalogLiveData;
    }

    public LiveData<BookModel> getOpenBook() {
        return openBookLiveData;
    }
}