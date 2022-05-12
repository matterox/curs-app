package com.publishing.curs.ui.booksample;

import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.ui.base.BaseViewModel;

public class BookSampleViewModel extends BaseViewModel {
    private final MutableLiveData<String> bookUrlLiveData;
    public BookSampleViewModel() {
        bookUrlLiveData = new MutableLiveData<>();
    }
    public void loadBook() {
        String bookLocation = Uri.encode("file:///android_asset/books/the-book-collector-example-2018-04.pdf");
        bookUrlLiveData.setValue("https://ndf.book24.ru/tools/pdf-reader/web/viewer.html?file=https://cdn.book24.ru/v2/ITD000000000972713/PDF/ITD000000000972713.pdf");
    }

    public LiveData<String> getBookUrl() {
        return bookUrlLiveData;
    }
}
