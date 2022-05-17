package com.androidaflevering.smartpark.ui.indstillinger;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
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
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.databinding.FragmentIndstillingerBinding;

import java.util.Locale;

public class IndstillingerFragment extends Fragment implements View.OnClickListener {

    public static final String LANGUAGE_DANISH = "Danish";
    public static final String LANGUAGE_ENGLISH = "English";

    public static String currentLanguageOfTheApp = LANGUAGE_DANISH;
    public static boolean veryFirstCreation = true;
    public static boolean veryFirstChoice = true;

    public IndstillingerFragment() {

    }

    public static IndstillingerFragment newInstance(String param1, String param2) {
        IndstillingerFragment fragment = new IndstillingerFragment();
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (veryFirstCreation) {
            veryFirstCreation = false;
            Locale locale;
            locale = new Locale("dk", "DK");

            Configuration config = new Configuration(getActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            getActivity().recreate();

            getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());

        }
    }

    private FragmentIndstillingerBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imageButtonDanish.setOnClickListener(this);
        binding.imageButtonEnglish.setOnClickListener(this);

        if (currentLanguageOfTheApp.equals(LANGUAGE_ENGLISH)) {
            binding.imageButtonDanish.setAlpha(0.5f);
            binding.imageButtonEnglish.setAlpha(1.0f);
            binding.textViewCurrentLanguageValue.setText(LANGUAGE_DANISH);
        }
        if (currentLanguageOfTheApp.equals(LANGUAGE_DANISH)){
            binding.imageButtonDanish.setAlpha(1.0f);
            binding.imageButtonEnglish.setAlpha(0.5f);
            binding.textViewCurrentLanguageValue.setText(LANGUAGE_ENGLISH;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imageButton_Danish) {

            this.currentLanguageOfTheApp = LANGUAGE_DANISH;

            Locale locale;
            locale = new Locale("dk", "DK");

            Configuration config = new Configuration(getActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            getActivity().recreate();

            getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());

        }
        if (view.getId() == R.id.imageButton_English) {

            this.currentLanguageOfTheApp = LANGUAGE_ENGLISH;

            Locale locale;
            locale = new Locale("en", "EN");

            Configuration config = new Configuration(getActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            getActivity().recreate();

            getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
        }
    }
}


  /* TextView tvSelect;
    RadioGroup rgLanguage;
    RadioButton rbEnglish;
    RadioButton rbDansk; */

   /* public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndstillingerViewModel indstillingerViewModel =
                new ViewModelProvider(this).get(IndstillingerViewModel.class);

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.vaelgSprog;
        indstillingerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/




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

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;*/

