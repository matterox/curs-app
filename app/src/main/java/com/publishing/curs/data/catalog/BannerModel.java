package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

import java.util.List;

public class BannerModel extends BaseCatalogModel {
    public List<String> bannerImagesUrl;

    public BannerModel(List<String> bannerImagesUrl) {
        this.bannerImagesUrl = bannerImagesUrl;
    }
}
