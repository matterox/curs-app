package com.publishing.curs.data.catalog.mappers;

import android.annotation.SuppressLint;

import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.database.entities.AuthorEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthorMapper {
    public static AuthorModel toAuthorModel(AuthorEntity entity) {
        return new AuthorModel(
                entity.id,
                entity.photo,
                entity.fullName,
                entity.description,
                parseDate(entity.dateOfBirth)
        );
    }

    @SuppressLint("SimpleDateFormat")
    private static String parseDate(String dateString) {
        SimpleDateFormat inDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String parsedDate = dateString;
        try {
            Date extractedDate = inDateFormat.parse(dateString);
            if (extractedDate != null) {
                parsedDate = outDateFormat.format(extractedDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }
}
