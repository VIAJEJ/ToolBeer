package com.androidaflevering.smartpark.ui.mineparkeringer;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.androidaflevering.smartpark.R;

public class MineParkeringStart extends AppCompatActivity {
    private ParkViewModel parkViewModel;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mine_parkeringer);
        editText = editText.findViewById(R.id.editText);
        textView = textView.findViewById(R.id.textView);

        parkViewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(ParkViewModel.class);
        parkViewModel.getAllNotes().observe((LifecycleOwner) this, notes -> {
            if (!notes.isEmpty()) {
                textView.setText("");
                for (Park n : notes) {
                    textView.append(n.getTitle() + "\n");
                }
            } else {
                textView.setText("Empty");
            }
        });
    }

    public void saveNote(View v) {
        parkViewModel.insert(new Park(editText.getText().toString(), "description", 1));
    }

    public void deleteAllNotes(View v) {
        parkViewModel.deleteAllNotes();
    }
}
