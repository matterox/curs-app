package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category")
public class CategoryEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Category")
    public long id;

    @ColumnInfo(name = "TitleRus")
    public String titleRus;

    @ColumnInfo(name = "TitleEng")
    public String titleEng;

    @ColumnInfo(name = "CatDescription")
    public String catDescription;
}
