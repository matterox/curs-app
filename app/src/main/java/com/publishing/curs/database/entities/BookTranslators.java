package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "books_has_translators", primaryKeys = {"id_Book", "id_Translator"})
public class BookTranslators {
    @ColumnInfo(name = "id_Book")
    public int bookId;

    @ColumnInfo(name = "id_Translator")
    public int translatorId;
}
