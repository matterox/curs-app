package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public class InfoModel extends BaseCatalogModel {
    public String label;
    public String infoText;

    public InfoModel(String label, String infoText) {
        this.label = label;
        this.infoText = infoText;
    }
}
