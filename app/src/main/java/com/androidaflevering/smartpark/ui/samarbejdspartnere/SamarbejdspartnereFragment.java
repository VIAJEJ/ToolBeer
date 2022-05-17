package com.androidaflevering.smartpark.ui.samarbejdspartnere;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.adapter.RecyclerViewAdapter;
import com.androidaflevering.smartpark.databinding.FragmentSamarbejdspartnereBinding;

public class SamarbejdspartnereFragment extends Fragment {

    private FragmentSamarbejdspartnereBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SamarbejdspartnereViewModel samarbejdspartnereViewModel =
             new ViewModelProvider(this).get(SamarbejdspartnereViewModel.class);

        binding = FragmentSamarbejdspartnereBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.samarbejdspartnereRecyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(root));

       return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}