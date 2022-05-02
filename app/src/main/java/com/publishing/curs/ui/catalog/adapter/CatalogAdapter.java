package com.publishing.curs.ui.catalog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.publishing.curs.R;
import com.publishing.curs.data.catalog.BannerModel;
import com.publishing.curs.data.catalog.InfoModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.HeaderModel;
import com.publishing.curs.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class CatalogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<BaseCatalogModel> data = new ArrayList<>();
    private final PublishSubject<BookModel> bookClickedSubject = PublishSubject.create();

    public Flowable<BookModel> bookClicked() { return bookClickedSubject.toFlowable(BackpressureStrategy.LATEST); }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HeaderViewHolder.VIEW_ID:
                View headerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(headerView);
            case BookViewHolder.VIEW_ID:
                View bookView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_book, parent, false);
                return new BookViewHolder(bookView);
            case BannerViewHolder.VIEW_ID:
                View bannerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_banner, parent, false);
                return new BannerViewHolder(bannerView);
            case InfoViewHolder.VIEW_ID:
                View infoView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_info, parent, false);
                return new InfoViewHolder(infoView);
            default:
                throw new IllegalArgumentException("View Type is not supported");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case HeaderViewHolder.VIEW_ID:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.bind((HeaderModel) data.get(position));
                break;
            case BookViewHolder.VIEW_ID:
                BookViewHolder bookViewHolder = (BookViewHolder) holder;
                bookViewHolder.bind((BookModel) data.get(position));
                break;
            case BannerViewHolder.VIEW_ID:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.bind((BannerModel) data.get(position));
                break;
            case InfoViewHolder.VIEW_ID:
                InfoViewHolder infoViewHolder = (InfoViewHolder) holder;
                infoViewHolder.bind((InfoModel) data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        BaseCatalogModel catalogModel = data.get(position);
        if (catalogModel instanceof HeaderModel) {
            return HeaderViewHolder.VIEW_ID;
        } else if (catalogModel instanceof BookModel) {
            return BookViewHolder.VIEW_ID;
        } else if (catalogModel instanceof BannerModel) {
            return BannerViewHolder.VIEW_ID;
        } else if (catalogModel instanceof InfoModel) {
            return InfoViewHolder.VIEW_ID;
        }
        throw new IllegalArgumentException("Model is not supported");
    }

    public void setData(List<BaseCatalogModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeader;
        public final static int VIEW_ID = 0;

        public HeaderViewHolder(View view) {
            super(view);
            tvHeader = (TextView) view.findViewById(R.id.tvHeader);
        }

        public void bind(HeaderModel headerModel) {
            tvHeader.setText(headerModel.headerText);
        }
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivCover;
        private final TextView tvName;
        private final TextView tvAuthor;
        private final CardView cvBook;
        public final static int VIEW_ID = 1;

        public BookViewHolder(View view) {
            super(view);
            ivCover = (ImageView) view.findViewById(R.id.ivBookCover);
            tvName = (TextView) view.findViewById(R.id.tvBookName);
            tvAuthor = (TextView) view.findViewById(R.id.tvBookAuthor);
            cvBook = (CardView) view.findViewById(R.id.cvBook);
            cvBook.setOnClickListener(v -> {
                bookClickedSubject.onNext((BookModel) data.get(getAdapterPosition()));
            });
        }

        public void bind(BookModel bookModel) {
            Glide.with(itemView.getContext())
                    .load(Utils.urlByIsbn(bookModel.isbn))
                    .error(R.drawable.img_not_available)
                    .into(ivCover);
            tvName.setText(bookModel.name);
            tvAuthor.setText(bookModel.authors);
        }
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        public final static int VIEW_ID = 2;
        private final BannerSlideAdapter adapter;
        private final Disposable scrollDisposable;
        private int currentPage = 0;

        public BannerViewHolder(View view) {
            super(view);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            ScrollingPagerIndicator recyclerIndicator = (ScrollingPagerIndicator) view.findViewById(R.id.indicator);
            adapter = new BannerSlideAdapter();
            recyclerView.setAdapter(adapter);
            recyclerIndicator.attachToRecyclerView(recyclerView);

            scrollDisposable = Observable.interval(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(l -> {
                        currentPage++;
                        if (currentPage > adapter.getItemCount()) {
                            currentPage = 0;
                        }
                        recyclerView.scrollToPosition(currentPage);
                    });
        }

        public void bind(BannerModel bannerModel) {
            adapter.setData(bannerModel.bannerImagesUrl);
        }
    }

    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeaderInfo;
        private final ImageView ivBanner;
        private final TextView tvInfo;

        public final static int VIEW_ID = 3;

        public InfoViewHolder(View view) {
            super(view);
            tvHeaderInfo = (TextView) view.findViewById(R.id.tvHeaderInfo);
            ivBanner = (ImageView) view.findViewById(R.id.ivBanner);
            tvInfo = (TextView) view.findViewById(R.id.tvInfo);
        }

        public void bind(InfoModel infoModel) {
            tvHeaderInfo.setText(infoModel.label);
            tvInfo.setText(infoModel.infoText);

            Glide.with(itemView.getContext())
                    .load(infoModel.imageUrl)
                    .centerCrop()
                    .into(ivBanner);
        }
    }

    public GridLayoutManager.SpanSizeLookup spanSizeLookup() {
        CatalogAdapter catalogAdapter = this;
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (catalogAdapter.getItemViewType(position)) {
                    case HeaderViewHolder.VIEW_ID:
                    case BannerViewHolder.VIEW_ID:
                    case InfoViewHolder.VIEW_ID:
                        return 2;
                    case BookViewHolder.VIEW_ID:
                        return 1;
                    default:
                        return 0;
                }
            }
        };
    }
}
