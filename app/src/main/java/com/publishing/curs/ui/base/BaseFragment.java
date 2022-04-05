package com.publishing.curs.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public NavController navigator() {
        return Navigation.findNavController(requireView());
    }
}
