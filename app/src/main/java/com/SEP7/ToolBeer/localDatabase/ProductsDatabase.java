package com.SEP7.ToolBeer.localDatabase;

import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.SEP7.ToolBeer.localDatabase.Entity.Products;

@Database(entities = {Products.class}, version = 2)
public abstract class ProductsDatabase extends RoomDatabase {

    private static ProductsDatabase instance;
    public abstract productsDAO productDAO;

}
