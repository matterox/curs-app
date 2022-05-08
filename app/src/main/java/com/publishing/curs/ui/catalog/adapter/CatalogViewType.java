package com.publishing.curs.ui.catalog.adapter;

import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.data.catalog.BannerModel;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.HeaderModel;
import com.publishing.curs.data.catalog.InfoModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public enum CatalogViewType {
    HEADER_VIEW(0),
    BOOK_VIEW(1),
    BANNER_VIEW(2),
    INFO_VIEW(3),
    AUTHOR_VIEW(4);

    public final int value;

    CatalogViewType(int value) {
        this.value = value;
    }

    public static CatalogViewType fromInt(int value) {
        if (value == HEADER_VIEW.value) {
            return HEADER_VIEW;
        } else if (value == BOOK_VIEW.value) {
            return BOOK_VIEW;
        } else if (value == BANNER_VIEW.value) {
            return BANNER_VIEW;
        } else if (value == INFO_VIEW.value) {
            return INFO_VIEW;
        } else if (value == AUTHOR_VIEW.value) {
            return AUTHOR_VIEW;
        } else {
            throw new IllegalStateException("Unexpected value: " + value);
        }
    }

    public static CatalogViewType fromModel(BaseCatalogModel model) {
        if (model instanceof HeaderModel) {
            return CatalogViewType.HEADER_VIEW;
        } else if (model instanceof BookModel) {
            return CatalogViewType.BOOK_VIEW;
        } else if (model instanceof BannerModel) {
            return CatalogViewType.BANNER_VIEW;
        } else if (model instanceof InfoModel) {
            return CatalogViewType.INFO_VIEW;
        } else if (model instanceof AuthorModel) {
            return CatalogViewType.AUTHOR_VIEW;
        }
        throw new IllegalArgumentException("Model " + model.getClass().getName() + " is not supported");
    }
}
