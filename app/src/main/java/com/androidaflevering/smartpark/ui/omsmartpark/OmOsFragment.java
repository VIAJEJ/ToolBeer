package com.androidaflevering.smartpark.ui.omsmartpark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.databinding.FragmentOmOsBinding;

public class OmOsFragment extends Fragment {

    private FragmentOmOsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OmOsViewModel omOsViewModel =
                new ViewModelProvider(this).get(OmOsViewModel.class);

        binding = FragmentOmOsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOmOs;
        omOsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}