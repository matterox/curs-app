package com.publishing.curs.ui.book;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.databinding.ActivityBookBinding;
import com.publishing.curs.ui.base.BaseActivity;
import com.publishing.curs.utils.Utils;

public class BookActivity extends BaseActivity {

    private ActivityBookBinding binding;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        long bookId = getIntent().getLongExtra(BUNDLE_BOOK_ID, 0);
        bookViewModel.loadBook(bookId);

        bookViewModel.getBook().observe(this, this::updateBookData);
        bookViewModel.getTranslators().observe(this, this::updateTranslators);
        bookViewModel.getCategory().observe(this, this::updateCategory);
        bookViewModel.getFormat().observe(this, this::updateFormat);
        bookViewModel.getCycle().observe(this, this::updateCycle);
        bookViewModel.getSeries().observe(this, this::updateSeries);
        bookViewModel.getRefreshing().observe(this, this::updateRefreshing);
        bookViewModel.getError().observe(this, this::showError);

        binding.tvReadSnippet.setOnClickListener(v -> bookViewModel.readSnippetClicked());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void updateBookData(BookModel bookModel) {
        getSupportActionBar().setTitle(bookModel.name);
        Glide.with(this)
                .load(Utils.urlByIsbn(bookModel.isbn))
                .into(binding.ivBookCover);
        binding.tvBookName.setText(bookModel.name);
        binding.tvAuthors.setText(bookModel.authors);
        binding.tvInfo.setText(bookModel.bookDescription);
        binding.tvIsbn.setText(bookModel.isbn);
        binding.tvYear.setText(bookModel.year);
        binding.tvPages.setText(bookModel.pages);
        binding.tvWeigh.setText(bookModel.weigh + " kg");
    }

    private void updateTranslators(String translators) {
        if (!translators.isEmpty()) {
            binding.rowTranslators.setVisibility(View.VISIBLE);
            binding.tvTranslators.setText(translators);
        } else {
            binding.rowTranslators.setVisibility(View.GONE);
        }
    }

    private void updateCategory(String category) {
        binding.tvCategory.setText(category);
    }

    private void updateFormat(String format) {
        if (!format.isEmpty()) {
            binding.rowFormat.setVisibility(View.VISIBLE);
            binding.tvFormat.setText(format);
        } else {
            binding.rowFormat.setVisibility(View.GONE);
        }
    }

    private void updateCycle(String cycle) {
        if (!cycle.isEmpty()) {
            binding.rowCycle.setVisibility(View.VISIBLE);
            binding.tvCycle.setText(cycle);
        } else {
            binding.rowCycle.setVisibility(View.GONE);
        }
    }

    private void updateSeries(String series) {
        if (!series.isEmpty()) {
            binding.rowSeries.setVisibility(View.VISIBLE);
            binding.tvSeries.setText(series);
        } else {
            binding.rowSeries.setVisibility(View.GONE);
        }
    }

    private void updateRefreshing(boolean isLoading) {
        if (isLoading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
        }
    }

    public static Bundle args(long bookId) {
        Bundle bundle = new Bundle();
        bundle.putLong(BUNDLE_BOOK_ID, bookId);
        return bundle;
    }

    private static final String BUNDLE_BOOK_ID = "BOOK_ID";
}