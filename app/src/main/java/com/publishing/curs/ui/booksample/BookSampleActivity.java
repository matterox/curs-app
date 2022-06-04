package com.publishing.curs.ui.booksample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.publishing.curs.R;
import com.publishing.curs.databinding.ActivityBookSampleBinding;
import com.publishing.curs.ui.base.BaseActivity;

public class BookSampleActivity extends BaseActivity {
    private ActivityBookSampleBinding binding;
    private BookSampleViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookSampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_snippet));

        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptEnabled(true);
        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                android.util.Log.d("WebView", consoleMessage.message());
                return true;
            }
        });

        viewModel = new ViewModelProvider(this).get(BookSampleViewModel.class);

        viewModel.getBookUrl().observe(this, this::loadBook);
        viewModel.getRefreshing().observe(this, this::updateRefreshing);
        viewModel.getError().observe(this, this::showError);

        long bookId = getIntent().getLongExtra(BUNDLE_BOOK_ID, 0);
        viewModel.loadBook(bookId);
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

    private void updateRefreshing(boolean isRefreshing) {
        if (isRefreshing) {
            binding.webView.setVisibility(View.GONE);
            binding.pbLoading.setVisibility(View.VISIBLE);
        } else {
            binding.webView.setVisibility(View.VISIBLE);
            binding.pbLoading.setVisibility(View.GONE);
        }
    }

    private void loadBook(String url) {
        binding.webView.loadUrl(url);
    }

    public static Intent getIntent(Context context, long bookId) {
        Intent intent = new Intent(context, BookSampleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong(BUNDLE_BOOK_ID, bookId);
        intent.putExtras(bundle);
        return intent;
    }

    private static final String BUNDLE_BOOK_ID = "BOOK_ID";
}
