package com.publishing.curs.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.publishing.curs.MainActivity;
import com.publishing.curs.R;
import com.publishing.curs.databinding.ActivitySplashBinding;
import com.publishing.curs.ui.base.BaseActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {
    private ActivitySplashBinding binding;
    private SplashViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        viewModel.getSplashLoaded().observe(this, l -> openMainActivity());

        binding.imageView.setBackgroundResource(R.drawable.book_open_anim);
        AnimationDrawable bg = (AnimationDrawable) binding.imageView.getBackground();
        bg.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void openMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
