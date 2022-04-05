package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public class BookModel extends BaseCatalogModel {
    public long bookId;
    public String name;
    public String authors;
    public String imageUrl;
    public String bookDescription;
    public String isbn;
    public String year;
    public String pages;
    public String weigh;

    public BookModel(long bookId, String name, String authors, String imageUrl,
                     String bookDescription, String isbn, String year, String pages, String weigh) {
        this.bookId = bookId;
        this.name = name;
        this.authors = authors;
        this.imageUrl = imageUrl;
        this.bookDescription = bookDescription;
        this.isbn = isbn;
        this.year = year;
        this.pages = pages;
        this.weigh = weigh;
    }
}
