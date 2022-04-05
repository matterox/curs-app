package com.publishing.curs.database.entities.relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.publishing.curs.database.entities.BookEntity;
import com.publishing.curs.database.entities.BookTranslators;
import com.publishing.curs.database.entities.TranslatorEntity;

import java.util.List;

public class BookWithTranslators {
    @Embedded
    public BookEntity book;

    @Relation(parentColumn = "id_Book", entityColumn = "id_Translator", associateBy = @Junction(BookTranslators.class))
    public List<TranslatorEntity> translators;

    public static String getTranslators(BookWithTranslators bookWithTranslators) {
        StringBuilder translators = new StringBuilder();
        for (TranslatorEntity translator : bookWithTranslators.translators) {
            translators.append(translator.fullName).append(",");
        }
        if (translators.length() > 0) {
            translators.deleteCharAt(translators.length() - 1);
        }
        return translators.toString();
    }
}
