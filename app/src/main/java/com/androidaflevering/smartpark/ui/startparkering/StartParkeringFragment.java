package com.androidaflevering.smartpark.ui.startparkering;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.databinding.FragmentStartParkeringBinding;

public class StartParkeringFragment extends Fragment {

    EditText editText;

    private FragmentStartParkeringBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StartParkeringViewModel startParkeringViewModel =
                new ViewModelProvider(this).get(StartParkeringViewModel.class);

        binding = FragmentStartParkeringBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFindParkering;
        startParkeringViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = (EditText) view.findViewById(R.id.samarbejdspartnereRecyclerView);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=parkering near " + editText.getText());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}