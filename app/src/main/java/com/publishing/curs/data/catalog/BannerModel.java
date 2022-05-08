package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.List;
import java.util.Objects;

public class BannerModel extends BaseCatalogModel {
    public List<String> bannerImagesUrl;

    public BannerModel(List<String> bannerImagesUrl) {
        this.bannerImagesUrl = bannerImagesUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BannerModel that = (BannerModel) o;
        return Objects.equals(bannerImagesUrl, that.bannerImagesUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bannerImagesUrl);
    }
}
