package com.androidaflevering.smartpark.ui.indstillinger;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.databinding.FragmentIndstillingerBinding;
import com.firebase.ui.auth.data.model.Resource;

import org.w3c.dom.Text;

public class IndstillingerFragment extends Fragment {

    private FragmentIndstillingerBinding binding;

    TextView tvSelect = getView().findViewById(R.id.vaelgSprog);
    RadioGroup rgLanguage = getView().findViewById(R.id.rg_language);
    RadioButton rbEnglish = getView().findViewById(R.id.rb_english);
    RadioButton rbDanish = getView().findViewById(R.id.rb_dansk);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndstillingerViewModel indstillingerViewModel =
                new ViewModelProvider(this).get(IndstillingerViewModel.class);

        binding = FragmentIndstillingerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.vaelgSprog;
        indstillingerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

//        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (i) {
//                    case R.id.rb_english:
//                        String language = "en";
//                        setLocale(language);
//
//                }
//            }
//        });
  }

//    private void setLocale(String language) {
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}