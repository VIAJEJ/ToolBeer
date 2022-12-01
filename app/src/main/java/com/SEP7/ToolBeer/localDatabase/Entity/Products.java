package com.SEP7.ToolBeer.localDatabase.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produkter_table")

public class Products {

    @PrimaryKey(autoGenerate = true) private int ProtID;

    @ColumnInfo(name= "ProdName") private String prodName;

    @ColumnInfo(name = "AlcoholP")
    private String alcoholP;

    @ColumnInfo(name = "Type")
    private String type;

    @ColumnInfo(name = "Description")
    private String description;

    public Products(String prodName, String alcoholP, String type, String description) {
        this.prodName =prodName;
        this.alcoholP =alcoholP;
        this.type = type;
        this.description = description;
    }

    public int getProtID() {
        return ProtID;
    }

    public void setProtID(int protID) {
        ProtID = protID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String pName) {
        this.prodName = pName;
    }

    public String getAlcoholP() {
        return alcoholP;
    }

    public void setAlcoholP(String alcoholP) {
        this.alcoholP = alcoholP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
