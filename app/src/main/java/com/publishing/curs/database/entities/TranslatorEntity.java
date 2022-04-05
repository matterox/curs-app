package com.publishing.curs.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "translators")
public class TranslatorEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Translator")
    public long id;

    @ColumnInfo(name = "TFullName")
    public String fullName;
}
