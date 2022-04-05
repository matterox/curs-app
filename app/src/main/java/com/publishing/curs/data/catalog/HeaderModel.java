package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public class HeaderModel extends BaseCatalogModel {
    public String headerText;

    public HeaderModel(String headerText) {
        this.headerText = headerText;
    }
}
