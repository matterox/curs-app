package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.Objects;

public class InfoModel extends BaseCatalogModel {
    public String label;
    public String infoText;
    public String imageUrl;

    public InfoModel(String label, String infoText, String imageUrl) {
        this.label = label;
        this.infoText = infoText;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoModel infoModel = (InfoModel) o;
        return label.equals(infoModel.label) && Objects.equals(infoText, infoModel.infoText) && Objects.equals(imageUrl, infoModel.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, infoText, imageUrl);
    }
}
