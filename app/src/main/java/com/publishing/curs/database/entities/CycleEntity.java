package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cycles")
public class CycleEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Cycle")
    public long id;

    @ColumnInfo(name = "CycTitle")
    public String title;

    @ColumnInfo(name = "Quantity")
    public Integer quantity;
}
