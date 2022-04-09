package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public class InfoModel extends BaseCatalogModel {
    public String label;
    public String infoText;
    public String imageUrl;

    public InfoModel(String label, String infoText, String imageUrl) {
        this.label = label;
        this.infoText = infoText;
        this.imageUrl = imageUrl;
    }
}
