package com.publishing.curs.data.catalog.mappers;

import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.database.entities.AuthorEntity;

public class AuthorMapper {
    public static AuthorModel toAuthorModel(AuthorEntity entity) {
        return new AuthorModel(
                entity.id,
                entity.photo,
                entity.fullName,
                entity.description,
                entity.dateOfBirth
        );
    }
}
