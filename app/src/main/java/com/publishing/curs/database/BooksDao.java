package com.publishing.curs.database;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.publishing.curs.database.entities.AuthorEntity;
import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.CategoryEntity;
import com.publishing.curs.database.entities.CycleEntity;
import com.publishing.curs.database.entities.FormatEntity;
import com.publishing.curs.database.entities.SeriesEntity;
import com.publishing.curs.database.entities.relation.BookWithAuthors;
import com.publishing.curs.database.entities.relation.BookWithTranslators;
import com.publishing.curs.database.entities.relation.CategoryWithBooksAndAuthors;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface BooksDao {
    @Transaction
    @Query("SELECT * FROM category")
    Single<List<CategoryWithBooksAndAuthors>> getAllBooksAndCategories();

    @Query("SELECT * FROM category WHERE id_Category = :categoryId")
    Single<CategoryEntity> getCategory(long categoryId);

    @Transaction
    @Query("SELECT * FROM books WHERE id_Book = :bookId")
    Single<BookWithAuthors> getBookAndAuthors(long bookId);

    @Transaction
    @Query("SELECT * FROM books WHERE id_Book = :bookId")
    Single<BookEntity> getBook(long bookId);

    @Query("SELECT * FROM authors")
    Single<List<AuthorEntity>> getAuthors();

    @Query("SELECT * FROM authors WHERE id_Author = :authorId")
    Single<AuthorEntity> getAuthor(long authorId);

    @Transaction
    @Query("SELECT * FROM books WHERE id_Book = :bookId")
    Single<BookWithTranslators> getTranslatorForBook(long bookId);

    @Query("SELECT * FROM cycles WHERE id_Cycle = :cycleId")
    Single<CycleEntity> getCycle(long cycleId);

    @Query("SELECT * FROM series WHERE id_Seria = :seriesId")
    Single<SeriesEntity> getSeries(long seriesId);

    @Query("SELECT * FROM formats WHERE id_Format = :formatId")
    Single<FormatEntity> getFormat(long formatId);

    @Transaction
    @Query("SELECT * FROM books WHERE is_Best = 1")
    Single<List<BookWithAuthors>> getBestBooks();
}
