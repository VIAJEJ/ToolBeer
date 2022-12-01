package com.SEP7.ToolBeer.localDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.SEP7.ToolBeer.localDatabase.DAO.UsersDAO;
import com.SEP7.ToolBeer.localDatabase.Entity.Users;


@Database(entities = {Users.class}, version = 2)
public abstract class UsersDatabase extends RoomDatabase {

    private static UsersDatabase instance;
    public abstract UsersDAO usersDao();

    public static synchronized UsersDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UsersDatabase.class,
                            "UsersDatabase").fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
