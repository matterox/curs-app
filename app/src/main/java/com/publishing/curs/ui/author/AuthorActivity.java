package com.publishing.curs.ui.author;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.publishing.curs.R;
import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.databinding.ActivityAuthorBinding;
import com.publishing.curs.ui.base.BaseActivity;

public class AuthorActivity extends BaseActivity {

    private ActivityAuthorBinding binding;
    private AuthorViewModel authorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);
        long authorId = getIntent().getLongExtra(BUNDLE_AUTHOR_ID, 0);
        authorViewModel.loadAuthorDetails(authorId);
        authorViewModel.getRefreshing().observe(this, this::updateRefreshing);
        authorViewModel.getError().observe(this, this::showError);
        authorViewModel.getAuthor().observe(this, this::updateAuthor);
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

    private void updateAuthor(AuthorModel authorModel) {
        getSupportActionBar().setTitle(authorModel.authorName);
        Glide.with(this)
                .load(authorModel.imageUrl)
                .error(R.drawable.img_not_available)
                .into(binding.ivAuthorImage);
        binding.tvAuthorName.setText(authorModel.authorName);
        binding.tvDateOfBirth.setText(authorModel.birthday);
        binding.tvBiography.setText(authorModel.biography);
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
        bundle.putLong(BUNDLE_AUTHOR_ID, bookId);
        return bundle;
    }

    private static final String BUNDLE_AUTHOR_ID = "AUTHOR_ID";
}
