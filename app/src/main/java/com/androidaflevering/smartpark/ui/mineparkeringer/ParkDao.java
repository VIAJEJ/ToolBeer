package com.androidaflevering.smartpark.ui.mineparkeringer;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ParkDao {

    @Insert
    void insert(Park park);

    @Update
    void update(Park park);

    @Delete
    void delete(Park park);

    @Query("DELETE FROM park_table")
    void deleteAllNotes();

    @Query("SELECT * FROM park_table ORDER BY priority DESC")
    LiveData<List<Park>> getAllNotes();

}