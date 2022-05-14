package com.androidaflevering.smartpark.ui.mineparkeringer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.databinding.FragmentMineParkeringerBinding;

public class MineParkeringerFragment extends Fragment {

    private FragmentMineParkeringerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MineParkeringerViewModel mineParkeringerViewModel =
                new ViewModelProvider(this).get(MineParkeringerViewModel.class);

        binding = FragmentMineParkeringerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMineParkeringer;
        mineParkeringerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}