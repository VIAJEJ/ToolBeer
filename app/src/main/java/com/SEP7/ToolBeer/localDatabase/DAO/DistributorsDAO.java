package com.SEP7.ToolBeer.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;

import java.beans.PropertyChangeListener;
import java.util.List;

@Dao
public interface DistributorsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Distributors distributor);

    @Query("Select * from Distributors_table")
    List<Distributors> getAllDistributors();
}
