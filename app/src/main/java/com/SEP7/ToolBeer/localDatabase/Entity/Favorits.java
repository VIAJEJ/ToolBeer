package com.SEP7.ToolBeer.localDatabase.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys={"protID","userID"})
public class Favorits {


    private int protID;

    @NonNull
    private String userID;

    public Favorits(int protID, String userID) {
        this.protID = protID;
        this.userID = userID;
    }

    public int getProtID() {
        return protID;
    }

    public void setProtID(int protID) {
        this.protID = protID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
