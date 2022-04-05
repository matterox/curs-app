package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "series")
public class SeriesEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Seria")
    public long id;

    @ColumnInfo(name = "SerTitle")
    public String title;

    @ColumnInfo(name = "SerDescription")
    public String description;
}
