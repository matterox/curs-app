package com.publishing.curs.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.publishing.curs.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment {

    private FragmentContactBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Glide.with(requireContext())
                .load("file:///android_asset/images/image_7.png")
                .into(binding.ivMap);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}