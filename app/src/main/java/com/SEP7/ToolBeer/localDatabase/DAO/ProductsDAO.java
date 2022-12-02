package com.SEP7.ToolBeer.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.SEP7.ToolBeer.localDatabase.Entity.Products;

import java.util.List;


@Dao
public interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Products produkt);

    @Update
    void update(Products produkt);

    @Query("Select * from produkter_table")
    List<Products> getAllProducts();
}