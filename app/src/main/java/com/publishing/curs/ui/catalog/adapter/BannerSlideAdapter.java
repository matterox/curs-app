package com.publishing.curs.ui.catalog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.publishing.curs.R;

import java.util.ArrayList;
import java.util.List;

public class BannerSlideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> data = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View headerView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_banner_slide, parent, false);
        return new BannerSlideViewHolder(headerView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerSlideViewHolder bannerSlideViewHolder = (BannerSlideViewHolder) holder;
        bannerSlideViewHolder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static class BannerSlideViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivBanner;

        public BannerSlideViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            ivBanner = (ImageView) view.findViewById(R.id.ivBanner);
        }

        public void bind(String bannerImageUrl) {
            Glide.with(itemView.getContext())
                    .load(bannerImageUrl)
                    .centerCrop()
                    .into(ivBanner);
        }
    }
}
