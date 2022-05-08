package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.Objects;

public class AuthorModel extends BaseCatalogModel {
    public long authorId;
    public String imageUrl;
    public String authorName;
    public String biography;
    public String birthday;

    public AuthorModel(long authorId, String imageUrl, String authorName, String biography, String birthday) {
        this.authorId = authorId;
        this.imageUrl = imageUrl;
        this.authorName = authorName;
        this.biography = biography;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorModel that = (AuthorModel) o;
        return authorId == that.authorId && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(authorName, that.authorName) && Objects.equals(biography, that.biography) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, imageUrl, authorName, biography, birthday);
    }
}
