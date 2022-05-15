package com.androidaflevering.smartpark.ui.mineparkeringer;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Park.class}, version = 1)
public abstract class ParkDatabase extends RoomDatabase {

    private static ParkDatabase instance;
    public abstract ParkDao parkDao();

    public static synchronized ParkDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    ParkDatabase.class, "park_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
