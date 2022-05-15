package com.androidaflevering.smartpark.ui.mineparkeringer;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkRepository {
    private static ParkRepository instance;
    private final ParkDao parkDao;
    private final LiveData<List<Park>> allNotes;
    private final ExecutorService executorService;

    private ParkRepository(Application application) {
        ParkDatabase database = ParkDatabase.getInstance(application);
        parkDao = database.parkDao();
        allNotes = parkDao.getAllNotes();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized ParkRepository getInstance(Application application) {
        if (instance == null)
            instance = new ParkRepository(application);

        return instance;
    }

    public LiveData<List<Park>> getAllNotes() {
        return allNotes;
    }

    public void insert(Park park) {
        executorService.execute(() -> parkDao.insert(park));
    }

    public void deleteAllNotes() {
        executorService.execute(parkDao::deleteAllNotes);
    }
}
