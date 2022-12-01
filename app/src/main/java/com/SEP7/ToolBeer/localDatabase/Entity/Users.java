package com.SEP7.ToolBeer.localDatabase.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users_table")
public class Users {

    @PrimaryKey(autoGenerate = true)
    private int userID;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Age")
    private int age;

    @ColumnInfo(name = "Address")
    private String address;

    @ColumnInfo(name = "Country")
    private String country;

    public Users(String name, int age, String address, String country) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.country = country;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
