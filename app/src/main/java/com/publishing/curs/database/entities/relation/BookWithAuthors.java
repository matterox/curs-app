package com.publishing.curs.database.entities.relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.database.entities.BookAuthorEntity;
import com.publishing.curs.database.entities.BookEntity;

import java.util.List;

public class BookWithAuthors {
    @Embedded
    public BookEntity book;

    @Relation(parentColumn = "id_Book", entityColumn = "id_Author", associateBy = @Junction(BookAuthorEntity.class))
    public List<AuthorEntity> authors;

    public static BookModel toBookModel(BookWithAuthors bookWithAuthors) {
        StringBuilder authors = new StringBuilder();
        for (AuthorEntity author : bookWithAuthors.authors) {
            authors.append(author.fullName).append(",");
        }
        if (authors.length() > 0) {
            authors.deleteCharAt(authors.length() - 1);
        }
        BookEntity bookEntity = bookWithAuthors.book;
        String bookYear = "-";
        if (bookEntity.year != null && bookEntity.year > 0)
            bookYear = bookEntity.year.toString();
        String bookPages = "-";
        if (bookEntity.pages != null && bookEntity.pages > 0)
            bookPages = bookEntity.pages.toString();
        String bookWeigh = "-";
        if (bookEntity.weigh != null && bookEntity.weigh > 0)
            bookWeigh = bookEntity.weigh.toString();

        return new BookModel(
                bookEntity.id,
                bookEntity.title,
                authors.toString(),
                bookEntity.coverImage,
                bookEntity.description,
                bookEntity.isbn,
                bookYear,
                bookPages,
                bookWeigh
        );
    }
}
