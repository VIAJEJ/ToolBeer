package com.SEP7.ToolBeer.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface Users {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users user);

}
