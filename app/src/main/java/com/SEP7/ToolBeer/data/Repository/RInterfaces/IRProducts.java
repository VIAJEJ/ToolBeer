package com.SEP7.ToolBeer.data.Repository.RInterfaces;

import com.SEP7.ToolBeer.localDatabase.Entity.Products;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface IRProducts {


    List<Products> getProducts();

    void collectProducts();

    void addPropertyChangeListener(String eventProducts, PropertyChangeListener listener);
}
