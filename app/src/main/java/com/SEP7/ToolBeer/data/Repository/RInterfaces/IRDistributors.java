package com.SEP7.ToolBeer.data.Repository.RInterfaces;

import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface IRDistributors {

    void collectDistributors();

    ArrayList<Distributors> getDistributors();

    void addPropertyChangeListener(String name, PropertyChangeListener listener);
}
