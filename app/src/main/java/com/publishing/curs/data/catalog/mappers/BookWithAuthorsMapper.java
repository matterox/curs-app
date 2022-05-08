package com.publishing.curs.data.catalog.mappers;

import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.relation.BookWithAuthors;

public class BookWithAuthorsMapper {
    public static BookModel toBookModel(BookWithAuthors entity) {
        StringBuilder authors = new StringBuilder();
        for (AuthorEntity author : entity.authors) {
            authors.append(author.fullName).append(",");
        }
        if (authors.length() > 0) {
            authors.deleteCharAt(authors.length() - 1);
        }
        BookEntity bookEntity = entity.book;
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
