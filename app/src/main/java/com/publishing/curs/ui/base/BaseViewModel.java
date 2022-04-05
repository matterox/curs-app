package com.publishing.curs.ui.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected final MutableLiveData<Boolean> refreshingLiveData;
    protected final MutableLiveData<String> errorLiveData;

    public BaseViewModel() {
        refreshingLiveData = new MutableLiveData<>();
        errorLiveData = new MutableLiveData<>();
        onStart();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        clearDisposables();
    }

    private void clearDisposables() {
        compositeDisposable.dispose();
    }

    protected void onStart() {

    }

    protected void track(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public LiveData<Boolean> getRefreshing() {
        return refreshingLiveData;
    }

    public LiveData<String> getError() { return errorLiveData; }
}
