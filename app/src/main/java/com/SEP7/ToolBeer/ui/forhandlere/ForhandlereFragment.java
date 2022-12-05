package com.SEP7.ToolBeer.ui.forhandlere;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.adapter.DistributorsRecyclerViewAdapter;
import com.SEP7.ToolBeer.databinding.FragmentForhandlereBinding;


public class ForhandlereFragment extends Fragment {

    private FragmentForhandlereBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ForhandlereViewModel forhandlereViewModel =
             new ViewModelProvider(this).get(ForhandlereViewModel.class);

        binding = FragmentForhandlereBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.forhandler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new DistributorsRecyclerViewAdapter(root));

       return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}