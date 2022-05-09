package com.publishing.curs.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.publishing.curs.R;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseFragment extends Fragment {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearDisposables();
    }

    private void clearDisposables() {
        compositeDisposable.dispose();
    }

    protected void track(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void showError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(getString(R.string.common_error));
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.common_ok), null);
        builder.show();
    }

    protected void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.common_ok), null);
        builder.show();
    }

    public NavController navigator() {
        return Navigation.findNavController(requireView());
    }
}
