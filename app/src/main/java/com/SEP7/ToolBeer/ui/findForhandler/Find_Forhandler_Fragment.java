package com.SEP7.ToolBeer.ui.findForhandler;

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

import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.databinding.FragmentFindForhandlerBinding;

public class Find_Forhandler_Fragment extends Fragment {

    EditText editText;

    private FragmentFindForhandlerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Find_Forhandler_ViewModel findForhandlerViewModel =
                new ViewModelProvider(this).get(Find_Forhandler_ViewModel.class);

        binding = FragmentFindForhandlerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFindForhandler;
        findForhandlerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.forhandler);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Coop near " + editText.getText());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
        Button button2 = view.findViewById(R.id.find_forhandler_lokation);
        button2.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Coop nearby");
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