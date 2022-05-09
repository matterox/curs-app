package com.publishing.curs.ui.contact;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.publishing.curs.R;
import com.publishing.curs.databinding.FragmentContactBinding;
import com.publishing.curs.ui.base.BaseFragment;

import java.io.InputStream;

public class ContactFragment extends BaseFragment {

    private FragmentContactBinding binding;
    private ContactViewModel contactViewModel;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                android.util.Log.d("WebView", consoleMessage.message());
                return true;
            }
        });

        try {
            InputStream is = getActivity().getAssets().open("html/yandex_map.html");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            String htmlText = new String(buffer);
            binding.webView.loadDataWithBaseURL(
                    "http://ru.yandex.api.yandexmapswebviewexample.ymapapp",
                    htmlText,
                    "text/html",
                    "UTF-8",
                    null
            );
        } catch (Throwable e) {
            e.printStackTrace();
        }
        contactViewModel.getMessageSent().observe(getViewLifecycleOwner(), this::messageSent);
        binding.btnSend.setOnClickListener(v -> contactViewModel.sendMessage(
                binding.etName.getText().toString(),
                binding.etEmail.getText().toString(),
                binding.etMessage.getText().toString()
        ));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void messageSent(Boolean success) {
        binding.etName.setText("");
        binding.etEmail.setText("");
        binding.etMessage.setText("");
        if (success) {
            showMessage(getString(R.string.common_success), getString(R.string.contact_message_send_success));
        } else {
            showError(getString(R.string.contact_message_fields_error));
        }
    }
}