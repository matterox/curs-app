package com.publishing.curs.ui.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.ui.base.BaseViewModel;
import com.publishing.curs.utils.Utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SplashViewModel extends BaseViewModel {
    private final MutableLiveData<Boolean> splashLoaded;

    public SplashViewModel() {
        splashLoaded = new MutableLiveData<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        track(Utils.randomDelayCompletable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> splashLoaded.setValue(true)));
    }

    public LiveData<Boolean> getSplashLoaded() {
        return splashLoaded;
    }
}
