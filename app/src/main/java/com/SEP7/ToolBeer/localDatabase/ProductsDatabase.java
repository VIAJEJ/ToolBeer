package com.SEP7.ToolBeer.localDatabase;

import android.content.Context;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room;

import com.SEP7.ToolBeer.localDatabase.DAO.ProductsDAO;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;

@Database(entities = {Products.class}, version = 2)
public abstract class ProductsDatabase extends RoomDatabase {

    private static ProductsDatabase instance;
    public abstract ProductsDAO productsDao();

    public static synchronized ProductsDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductsDatabase.class,
                    "ProductsDatabase").fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
