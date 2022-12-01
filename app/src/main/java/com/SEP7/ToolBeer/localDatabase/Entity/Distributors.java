package com.SEP7.ToolBeer.localDatabase.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Distributors {

    @PrimaryKey(autoGenerate = true)
    private int disId;

    @ColumnInfo(name = "Country")
    private String country;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Opening_Hours")
    private String openingHours;

    @ColumnInfo(name = "Website")
    private String website;

}
