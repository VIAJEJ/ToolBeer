package com.SEP7.ToolBeer.data.Repository.RInterfaces;

import com.SEP7.ToolBeer.localDatabase.Entity.Products;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface IRFavorits {

    void collectFavorits();

    void addFavorit(int prodID);

    void addPropertyChangeListener(String eventDistributors, PropertyChangeListener listener);

    public ArrayList<Products> getFavorits();
}
