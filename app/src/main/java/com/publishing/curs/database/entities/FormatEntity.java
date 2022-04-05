package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "formats")
public class FormatEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Format")
    public long id;

    @ColumnInfo(name = "Width")
    public Double width;

    @ColumnInfo(name = "Height")
    public Double height;
}
