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
import java.util.Objects;

public class IndstillingerFragment extends Fragment implements View.OnClickListener {

    public static final String LANGUAGE_DANISH = "Dansk";
    public static final String LANGUAGE_ENGLISH = "English";

    public static String currentLanguageOfTheApp = LANGUAGE_ENGLISH;

    public static boolean veryFirstCreation = true;

    public IndstillingerFragment() {
    }

    public static IndstillingerFragment newInstance(String param1, String param2) {
        return new IndstillingerFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (veryFirstCreation) {
            veryFirstCreation = false;
            Locale locale;
            locale = new Locale("en", "EN");

            Configuration config = new Configuration(requireActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            requireActivity().recreate();

            requireActivity().getBaseContext().getResources().updateConfiguration(config,
                    requireActivity().getBaseContext().getResources().getDisplayMetrics());
        }
    }

    private FragmentIndstillingerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndstillingerViewModel indstillingerViewModel =
                new ViewModelProvider(this).get(IndstillingerViewModel.class);

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imageButtonDanish.setOnClickListener(this);
        binding.imageButtonEnglish.setOnClickListener(this);

        if (currentLanguageOfTheApp.equals(LANGUAGE_DANISH)) {
            binding.textViewCurrentLanguageValue.setText(LANGUAGE_DANISH);
            binding.imageButtonDanish.setAlpha(0.5f);
            binding.imageButtonEnglish.setAlpha(1.0f);
        }
        if (currentLanguageOfTheApp.equals(LANGUAGE_ENGLISH)){
            binding.imageButtonDanish.setAlpha(1.0f);
            binding.imageButtonEnglish.setAlpha(0.5f);
            binding.textViewCurrentLanguageValue.setText(LANGUAGE_ENGLISH);
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

            currentLanguageOfTheApp = LANGUAGE_DANISH;

            Locale locale;
            locale = new Locale("da", "DA");

            Configuration config = new Configuration(requireActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            requireActivity().recreate();

            requireActivity().getBaseContext().getResources().updateConfiguration(config, requireActivity().getBaseContext().getResources().getDisplayMetrics());

        }
        if (view.getId() == R.id.imageButton_English) {

            currentLanguageOfTheApp = LANGUAGE_ENGLISH;

            Locale locale;
            locale = new Locale("en", "EN");

            Configuration config = new Configuration(requireActivity().getBaseContext().getResources().getConfiguration());
            Locale.setDefault(locale);
            config.setLocale(locale);
            requireActivity().recreate();

            requireActivity().getBaseContext().getResources().updateConfiguration(config, requireActivity().getBaseContext().getResources().getDisplayMetrics());
        }
    }
}

