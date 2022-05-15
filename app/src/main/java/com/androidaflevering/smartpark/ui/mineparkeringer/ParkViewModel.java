package com.androidaflevering.smartpark.ui.mineparkeringer;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ParkViewModel extends AndroidViewModel {

    private final ParkRepository repository;

    public ParkViewModel(Application app) {
        super(app);
        repository = ParkRepository.getInstance(app);
    }

    public LiveData<List<Park>> getAllNotes() {
        return repository.getAllNotes();
    }

    public void insert(final Park park) {
        repository.insert(park);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }
}
