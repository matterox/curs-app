package com.publishing.curs.ui.authors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.publishing.curs.R;
import com.publishing.curs.data.catalog.AuthorModel;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.databinding.FragmentAuthorsBinding;
import com.publishing.curs.ui.base.BaseFragment;
import com.publishing.curs.ui.book.BookActivity;
import com.publishing.curs.ui.catalog.adapter.CatalogAdapter;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AuthorsFragment extends BaseFragment {

    private FragmentAuthorsBinding binding;

    private AuthorsViewModel authorsViewModel;

    private CatalogAdapter catalogAdapter;
    private final static int NUM_OF_COLUMNS = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        authorsViewModel = new ViewModelProvider(this).get(AuthorsViewModel.class);

        binding = FragmentAuthorsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        catalogAdapter = new CatalogAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), NUM_OF_COLUMNS);
        layoutManager.setSpanSizeLookup(catalogAdapter.spanSizeLookup());
        binding.rvAuthors.setLayoutManager(layoutManager);
        binding.rvAuthors.setAdapter(catalogAdapter);

        binding.srLayout.setOnRefreshListener(authorsViewModel::updateAuthors);
        authorsViewModel.getAutnorsModels().observe(getViewLifecycleOwner(), this::updateAuthorsData);
        authorsViewModel.getOpenAuthor().observe(getViewLifecycleOwner(), this::openAuthor);
        authorsViewModel.getRefreshing().observe(getViewLifecycleOwner(), this::updateRefreshing);
        authorsViewModel.getError().observe(getViewLifecycleOwner(), this::showError);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        track(catalogAdapter.authorClicked()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(book -> authorsViewModel.authorClicked(book)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateAuthorsData(List<BaseCatalogModel> data) {
        catalogAdapter.setData(data);
    }

    private void openAuthor(AuthorModel book) {
//        navigator().navigate(R.id.bookActivity, BookActivity.args(book.bookId));
    }

    private void updateRefreshing(boolean isRefreshing) {
        binding.srLayout.setRefreshing(isRefreshing);
    }
}
