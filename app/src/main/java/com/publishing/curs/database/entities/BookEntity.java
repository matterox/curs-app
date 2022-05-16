package com.publishing.curs.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class BookEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Book")
    public long id;

    @ColumnInfo(name = "Title")
    public String title;

    @ColumnInfo(name = "BDescription")
    public String description = "";

    @ColumnInfo(name = "ISBN")
    public String isbn;

    @ColumnInfo(name = "YDK")
    public String ydk;

    @ColumnInfo(name = "BBK")
    public String bbk;

    @ColumnInfo(name = "id_Category")
    public Integer category;

    @ColumnInfo(name = "id_Seria")
    public Integer seria;

    @ColumnInfo(name = "id_Cycle")
    public Integer cycle;

    @ColumnInfo(name = "id_Format")
    public Integer format;

    @ColumnInfo(name = "Year")
    public Integer year;

    @ColumnInfo(name = "Number_of_pages")
    public Integer pages;

    @ColumnInfo(name = "Weight")
    public Double weigh;

    @ColumnInfo(name = "Age")
    public String age;

    @ColumnInfo(name = "Cover", defaultValue = "https://covers.openlibrary.org/w/id/10408030-M.jpg")
    public String coverImage;

    @ColumnInfo(name = "Сirculation")
    public Integer circulation;

    @ColumnInfo(name = "Binding")
    public String binding;

    @ColumnInfo(name = "Status")
    public String status;

    @ColumnInfo(name = "is_Shown", defaultValue = "1")
    public Integer isShown;

    @ColumnInfo(name = "Number_in_Cycle")
    public Integer numberInCycle;

    @ColumnInfo(name = "is_Best", defaultValue = "0")
    @NonNull
    public Integer isBest = 0;

    @ColumnInfo(name = "snippet_Url")
    public String snippetUrl;
}
