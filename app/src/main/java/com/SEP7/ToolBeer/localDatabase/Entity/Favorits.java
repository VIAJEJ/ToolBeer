package com.SEP7.ToolBeer.localDatabase.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys={"protID","userID"})
public class Favorits {


    private int protID;

    private int userID;

    public Favorits(int protID, int userID) {
        this.protID = protID;
        this.userID = userID;
    }

    public int getProtID() {
        return protID;
    }

    public void setProtID(int protID) {
        this.protID = protID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
