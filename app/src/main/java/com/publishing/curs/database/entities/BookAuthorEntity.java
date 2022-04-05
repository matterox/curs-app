package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "books_has_authors", primaryKeys = {"id_Book", "id_Author"})
public class BookAuthorEntity {
    @ColumnInfo(name = "id_Book")
    public int bookId;

    @ColumnInfo(name = "id_Author")
    public int authorId;
}
