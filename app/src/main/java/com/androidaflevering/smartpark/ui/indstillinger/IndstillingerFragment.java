package com.androidaflevering.smartpark.ui.indstillinger;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.databinding.FragmentIndstillingerBinding;

import java.util.Locale;

public class IndstillingerFragment extends Fragment {

    private FragmentIndstillingerBinding binding;

  /* TextView tvSelect;
    RadioGroup rgLanguage;
    RadioButton rbEnglish;
    RadioButton rbDansk; */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndstillingerViewModel indstillingerViewModel =
                new ViewModelProvider(this).get(IndstillingerViewModel.class);

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.vaelgSprog;
        indstillingerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

   /* @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvSelect = getView().findViewById(R.id.vaelgSprog);
       rgLanguage = getView().findViewById(R.id.rg_language);
       rbEnglish = getView().findViewById(R.id.rb_english);
       rbDansk = getView().findViewById(R.id.rb_dansk);

       rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.rb_dansk:
                       String language = "da";
                     setLocale(language);
                     break;
                case R.id.rb_english:
                    setLocale("en-rGB");
                    break;
                }
           }
       });
  }

   private void setLocale(String language) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
       Configuration configuration = resources.getConfiguration();
       configuration.locale = new Locale(language);
       resources.updateConfiguration(configuration, metrics);
       onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfiguration) {
        super.onConfigurationChanged(newConfiguration);
        tvSelect.setText(R.string.vaelg_sprog);
        rbEnglish.setText(R.string.english);
        rbDansk.setText(R.string.dansk);

    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}