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
import com.publishing.curs.data.catalog.AuthorModel;
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
    private final PublishSubject<AuthorModel> authorClickedSubject = PublishSubject.create();

    public Flowable<BookModel> bookClicked() {
        return bookClickedSubject.toFlowable(BackpressureStrategy.LATEST);
    }

    public Flowable<AuthorModel> authorClicked() {
        return authorClickedSubject.toFlowable(BackpressureStrategy.LATEST);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (CatalogViewType.fromInt(viewType)) {
            case HEADER_VIEW:
                View headerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(headerView);
            case BOOK_VIEW:
                View bookView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_book, parent, false);
                return new BookViewHolder(bookView);
            case BANNER_VIEW:
                View bannerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_banner, parent, false);
                return new BannerViewHolder(bannerView);
            case INFO_VIEW:
                View infoView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_info, parent, false);
                return new InfoViewHolder(infoView);
            case AUTHOR_VIEW:
                View authorView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_author, parent, false);
                return new AuthorViewHolder(authorView);
            default:
                throw new IllegalArgumentException("View Type is not supported");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CatalogViewType viewType = CatalogViewType.fromInt(holder.getItemViewType());
        switch (viewType) {
            case HEADER_VIEW:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.bind((HeaderModel) data.get(position));
                break;
            case BOOK_VIEW:
                BookViewHolder bookViewHolder = (BookViewHolder) holder;
                bookViewHolder.bind((BookModel) data.get(position));
                break;
            case BANNER_VIEW:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.bind((BannerModel) data.get(position));
                break;
            case INFO_VIEW:
                InfoViewHolder infoViewHolder = (InfoViewHolder) holder;
                infoViewHolder.bind((InfoModel) data.get(position));
                break;
            case AUTHOR_VIEW:
                AuthorViewHolder authorViewHolder = (AuthorViewHolder) holder;
                authorViewHolder.bind((AuthorModel) data.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        BaseCatalogModel catalogModel = data.get(position);
        return CatalogViewType.fromModel(catalogModel).value;
    }

    public void setData(List<BaseCatalogModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeader;

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

        public BookViewHolder(View view) {
            super(view);
            ivCover = (ImageView) view.findViewById(R.id.ivBookCover);
            tvName = (TextView) view.findViewById(R.id.tvBookName);
            tvAuthor = (TextView) view.findViewById(R.id.tvBookAuthor);
            cvBook = (CardView) view.findViewById(R.id.cvBook);
            cvBook.setOnClickListener(v -> bookClickedSubject.onNext((BookModel) data.get(getAdapterPosition())));
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

    public class AuthorViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivAuthorImage;
        private final TextView tvName;
        private final CardView cvAuthor;

        public AuthorViewHolder(View view) {
            super(view);
            ivAuthorImage = (ImageView) view.findViewById(R.id.ivAuthorImage);
            tvName = (TextView) view.findViewById(R.id.tvAuthorName);
            cvAuthor = (CardView) view.findViewById(R.id.cvAuthor);
            cvAuthor.setOnClickListener(v -> authorClickedSubject.onNext((AuthorModel) data.get(getAdapterPosition())));
        }

        public void bind(AuthorModel authorModel) {
            Glide.with(itemView.getContext())
                    .load(authorModel.imageUrl)
                    .error(R.drawable.img_not_available)
                    .into(ivAuthorImage);
            tvName.setText(authorModel.authorName);
        }
    }

    public GridLayoutManager.SpanSizeLookup spanSizeLookup() {
        CatalogAdapter catalogAdapter = this;
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (CatalogViewType.fromInt(catalogAdapter.getItemViewType(position))) {
                    case HEADER_VIEW:
                    case BANNER_VIEW:
                    case INFO_VIEW:
                        return 2;
                    case BOOK_VIEW:
                    case AUTHOR_VIEW:
                        return 1;
                    default:
                        return 0;
                }
            }
        };
    }
}
