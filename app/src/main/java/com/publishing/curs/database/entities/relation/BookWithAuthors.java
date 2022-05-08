package com.publishing.curs.database.entities.relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.database.entities.BookAuthorEntity;
import com.publishing.curs.database.entities.BookEntity;

import java.util.List;

public class BookWithAuthors {
    @Embedded
    public BookEntity book;

    @Relation(parentColumn = "id_Book", entityColumn = "id_Author", associateBy = @Junction(BookAuthorEntity.class))
    public List<AuthorEntity> authors;
}
