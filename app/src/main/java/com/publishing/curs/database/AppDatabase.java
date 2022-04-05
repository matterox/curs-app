package com.publishing.curs.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.database.entities.BookAuthorEntity;
import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.BookTranslators;
import com.publishing.curs.database.entities.CategoryEntity;
import com.publishing.curs.database.entities.CycleEntity;
import com.publishing.curs.database.entities.FormatEntity;
import com.publishing.curs.database.entities.SeriesEntity;
import com.publishing.curs.database.entities.TranslatorEntity;

@Database(entities = {
        AuthorEntity.class,
        BookEntity.class,
        CategoryEntity.class,
        BookAuthorEntity.class,
        TranslatorEntity.class,
        SeriesEntity.class,
        CycleEntity.class,
        BookTranslators.class,
        FormatEntity.class,
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BooksDao booksDao();
}
