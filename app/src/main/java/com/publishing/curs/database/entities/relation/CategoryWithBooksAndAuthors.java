package com.publishing.curs.database.entities.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.CategoryEntity;

import java.util.List;

public class CategoryWithBooksAndAuthors {
    @Embedded
    public CategoryEntity category;

    @Relation(entity = BookEntity.class, parentColumn = "id_Category", entityColumn = "id_Category")
    public List<BookWithAuthors> booksWithAuthors;
}
