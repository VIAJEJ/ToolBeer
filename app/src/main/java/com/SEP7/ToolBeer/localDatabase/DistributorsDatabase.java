package com.SEP7.ToolBeer.localDatabase;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.SEP7.ToolBeer.localDatabase.DAO.DistributorsDAO;
import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;

@Database(entities = {Distributors.class}, version = 2)
public abstract class DistributorsDatabase extends RoomDatabase {

    private static DistributorsDatabase instance;
    public abstract DistributorsDAO distributorsDAO();

    public static synchronized DistributorsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DistributorsDatabase.class,
                    "UsersDatabase").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
