package com.publishing.curs.ui.catalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.publishing.curs.R;
import com.publishing.curs.data.catalog.BookModel;
import com.publishing.curs.data.catalog.base.BaseCatalogModel;
import com.publishing.curs.databinding.FragmentCatalogBinding;
import com.publishing.curs.ui.base.BaseFragment;
import com.publishing.curs.ui.book.BookActivity;
import com.publishing.curs.ui.catalog.adapter.CatalogAdapter;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CatalogFragment extends BaseFragment {

    private FragmentCatalogBinding binding;

    private CatalogViewModel catalogViewModel;

    private CatalogAdapter catalogAdapter;
    private final static int NUM_OF_COLUMNS = 2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        catalogViewModel = new ViewModelProvider(this).get(CatalogViewModel.class);

        binding = FragmentCatalogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        catalogAdapter = new CatalogAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), NUM_OF_COLUMNS);
        layoutManager.setSpanSizeLookup(catalogAdapter.spanSizeLookup());
        binding.rvCatalog.setLayoutManager(layoutManager);
        binding.rvCatalog.setAdapter(catalogAdapter);

        binding.srLayout.setOnRefreshListener(catalogViewModel::updateCatalog);
        catalogViewModel.getCatalogModels().observe(getViewLifecycleOwner(), this::updateBooksData);
        catalogViewModel.getOpenBook().observe(getViewLifecycleOwner(), this::openBook);
        catalogViewModel.getRefreshing().observe(getViewLifecycleOwner(), this::updateRefreshing);
        catalogViewModel.getError().observe(getViewLifecycleOwner(), this::showError);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        track(catalogAdapter.bookClicked()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(book -> catalogViewModel.bookClicked(book)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateBooksData(List<BaseCatalogModel> data) {
        catalogAdapter.setData(data);
    }

    private void openBook(BookModel book) {
        navigator().navigate(R.id.bookActivity, BookActivity.args(book.bookId));
    }

    private void updateRefreshing(boolean isRefreshing) {
        binding.srLayout.setRefreshing(isRefreshing);
    }
}