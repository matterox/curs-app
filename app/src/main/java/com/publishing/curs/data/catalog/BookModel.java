package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return bookId == bookModel.bookId && Objects.equals(name, bookModel.name) && Objects.equals(authors, bookModel.authors) && Objects.equals(imageUrl, bookModel.imageUrl) && Objects.equals(bookDescription, bookModel.bookDescription) && isbn.equals(bookModel.isbn) && Objects.equals(year, bookModel.year) && Objects.equals(pages, bookModel.pages) && Objects.equals(weigh, bookModel.weigh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, name, authors, imageUrl, bookDescription, isbn, year, pages, weigh);
    }
}
