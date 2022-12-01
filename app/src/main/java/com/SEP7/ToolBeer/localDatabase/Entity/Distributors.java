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

    public Distributors(String country, String name, String openingHours, String website) {
        this.country = country;
        this.name = name;
        this.openingHours = openingHours;
        this.website = website;
    }

    public int getDisId() {
        return disId;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
