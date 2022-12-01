package com.SEP7.ToolBeer.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.SEP7.ToolBeer.localDatabase.Entity.Favorits;

@Dao
public interface FavoritsDAO
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favorits favorit);

}
