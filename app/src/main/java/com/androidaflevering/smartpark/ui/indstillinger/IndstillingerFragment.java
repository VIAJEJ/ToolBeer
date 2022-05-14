package com.androidaflevering.smartpark.ui.indstillinger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.databinding.FragmentIndstillingerBinding;

public class IndstillingerFragment extends Fragment {

    private FragmentIndstillingerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndstillingerViewModel indstillingerViewModel =
                new ViewModelProvider(this).get(IndstillingerViewModel.class);

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textIndstillinger;
        indstillingerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}