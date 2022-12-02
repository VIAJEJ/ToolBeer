package com.SEP7.ToolBeer.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.SEP7.ToolBeer.localDatabase.Entity.Favorits;
import com.SEP7.ToolBeer.localDatabase.Entity.Users;

import java.util.List;

@Dao
public interface FavoritsDAO
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favorits favorit);

    @Query("Select * from Favorits where userID = :userId")
    List<Favorits> getAllFavorits(String userId);

    @Query("Insert into Favorits values(:protID,:userID)")
    void addFavorit(int protID, String userID);
}
