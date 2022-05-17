package com.androidaflevering.smartpark.ui.startparkering;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.androidaflevering.smartpark.R;
import com.androidaflevering.smartpark.databinding.FragmentStartParkeringBinding;

import java.util.ArrayList;

public class StartParkeringFragment extends AppCompatActivity {

    TextView textView;
    EditText editText;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_start_parkering);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("edit text", editText.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText(sharedPreferences.getString("editText","default value"));
    }
}