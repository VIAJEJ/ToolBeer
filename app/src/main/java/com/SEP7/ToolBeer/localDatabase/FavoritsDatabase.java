package com.SEP7.ToolBeer.localDatabase;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.SEP7.ToolBeer.localDatabase.DAO.FavoritsDAO;
import com.SEP7.ToolBeer.localDatabase.Entity.Favorits;

@Database(entities = {Favorits.class}, version = 3)
public abstract class FavoritsDatabase extends RoomDatabase {

    private static FavoritsDatabase instance;
    public abstract FavoritsDAO favoritsDAO();

    public static synchronized FavoritsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoritsDatabase.class,
                    "UsersDatabase").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}