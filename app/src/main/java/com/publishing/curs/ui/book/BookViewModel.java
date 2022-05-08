package com.publishing.curs.ui.book;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.App;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.mappers.BookWithAuthorsMapper;
import com.publishing.curs.database.BooksDao;
import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.relation.BookWithAuthors;
import com.publishing.curs.database.entities.relation.BookWithTranslators;
import com.publishing.curs.ui.base.BaseViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BookViewModel extends BaseViewModel {
    private final MutableLiveData<BookModel> bookLiveData;
    private final MutableLiveData<String> bookTranslatorsLiveData;
    private final MutableLiveData<String> categoryLiveData;
    private final MutableLiveData<String> formatLiveData;
    private final MutableLiveData<String> cycleLiveData;
    private final MutableLiveData<String> seriesiveData;
    private final MutableLiveData<Long> readSnippetLiveData;

    private final BooksDao booksDao = App.getInstance().getDatabase().booksDao();
    private long bookId = 0L;

    public BookViewModel() {
        bookLiveData = new MutableLiveData<>();
        bookTranslatorsLiveData = new MutableLiveData<>();
        categoryLiveData = new MutableLiveData<>();
        formatLiveData = new MutableLiveData<>();
        cycleLiveData = new MutableLiveData<>();
        seriesiveData = new MutableLiveData<>();
        readSnippetLiveData = new MutableLiveData<>();
    }

    public void loadBookDetails(long bookId) {
        this.bookId = bookId;
        track(
                booksDao.getBookAndAuthors(bookId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                        .subscribe(bookWithAuthors -> {
                            bookLiveData.setValue(BookWithAuthorsMapper.toBookModel(bookWithAuthors));
                            BookEntity book = bookWithAuthors.book;
                            Integer categoryId = book.category;
                            Integer seriaId = book.seria;
                            Integer cycleId = book.cycle;
                            Integer formatId = book.format;

                            if (categoryId != null) {
                                loadCategory(categoryId);
                            }
                            if (seriaId != null) {
                                loadSeria(seriaId);
                            }
                            if (cycleId != null) {
                                loadCycle(cycleId);
                            }
                            if (formatId != null) {
                                loadFormat(formatId);
                            }
                        }, throwable -> {
                            errorLiveData.setValue(throwable.getLocalizedMessage());
                        })
        );
        track(
                booksDao.getTranslatorForBook(bookId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                .subscribe(bookWithTranslators -> {
                    bookTranslatorsLiveData.setValue(BookWithTranslators.getTranslators(bookWithTranslators));
                }, throwable -> {
                    errorLiveData.setValue(throwable.getLocalizedMessage());
                })
        );
    }

    private void loadFormat(long formatId) {
        track(
                booksDao.getFormat(formatId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                        .subscribe(formatEntity -> {
                            formatLiveData.setValue(formatEntity.width + "x" + formatEntity.height);
                        }, throwable -> {
                            errorLiveData.setValue(throwable.getLocalizedMessage());
                        })
        );
    }

    private void loadCycle(long cycleId) {
        track(
                booksDao.getCycle(cycleId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                        .subscribe(cycleEntity -> {
                            cycleLiveData.setValue(cycleEntity.title + " (" + cycleEntity.quantity + ")");
                        }, throwable -> {
                            errorLiveData.setValue(throwable.getLocalizedMessage());
                        })
        );
    }

    private void loadSeria(long seriaId) {
        track(
                booksDao.getSeries(seriaId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                        .subscribe(seriesEntity -> {
                            seriesiveData.setValue(seriesEntity.title);
                        }, throwable -> {
                            errorLiveData.setValue(throwable.getLocalizedMessage());
                        })
        );
    }

    private void loadCategory(int categoryId) {
        track(
                booksDao.getCategory(categoryId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> refreshingLiveData.setValue(true))
                        .doOnTerminate(() -> refreshingLiveData.setValue(false))
                .subscribe(categoryEntity -> {
                    categoryLiveData.setValue(categoryEntity.titleEng);
                }, throwable -> {
                    errorLiveData.setValue(throwable.getLocalizedMessage());
                })
        );
    }

    public void readSnippetClicked() {
        readSnippetLiveData.setValue(bookId);
    }

    public LiveData<BookModel> getBook() {
        return bookLiveData;
    }

    public LiveData<String> getTranslators() {return bookTranslatorsLiveData;}

    public LiveData<String> getCategory() {
        return categoryLiveData;
    }

    public LiveData<String> getFormat() {
        return formatLiveData;
    }

    public LiveData<String> getCycle() {
        return cycleLiveData;
    }

    public LiveData<String> getSeries() {
        return seriesiveData;
    }

    public LiveData<Long> getReadSnippet() { return readSnippetLiveData; }
}
