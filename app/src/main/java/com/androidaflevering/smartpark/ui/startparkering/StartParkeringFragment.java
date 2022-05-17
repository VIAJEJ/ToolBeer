package com.androidaflevering.smartpark.ui.startparkering;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.databinding.FragmentStartParkeringBinding;

public class StartParkeringFragment extends Fragment {

    private FragmentStartParkeringBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StartParkeringViewModel startParkeringViewModel =
                new ViewModelProvider(this).get(StartParkeringViewModel.class);

        binding = FragmentStartParkeringBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStartParkering;
        startParkeringViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}