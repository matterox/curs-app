package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.Objects;

public class HeaderModel extends BaseCatalogModel {
    public String headerText;

    public HeaderModel(String headerText) {
        this.headerText = headerText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeaderModel that = (HeaderModel) o;
        return headerText.equals(that.headerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headerText);
    }
}
