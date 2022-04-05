package com.publishing.curs.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "authors")
public class AuthorEntity {
    @PrimaryKey
    @ColumnInfo(name = "id_Author")
    public long id;

    @ColumnInfo(name = "AFullName")
    @NonNull
    public String fullName = "";

    @ColumnInfo(name = "ADate_of_Birth")
    public String dateOfBirth;

    @ColumnInfo(name = "ADescription")
    public String description;

    @ColumnInfo(name = "Foto", defaultValue = "fotos/no_foto.jpg")
    public String photo;
}
