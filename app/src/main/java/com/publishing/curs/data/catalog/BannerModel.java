package com.publishing.curs.data.catalog;

import com.publishing.curs.data.catalog.base.BaseCatalogModel;

public class BannerModel extends BaseCatalogModel {
    public String bannerImageUrl;

    public BannerModel(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }
}
