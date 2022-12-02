package com.SEP7.ToolBeer.data.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRDistributors;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRFavorits;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRProducts;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRUsers;

import com.SEP7.ToolBeer.localDatabase.DAO.DistributorsDAO;
import com.SEP7.ToolBeer.localDatabase.DAO.FavoritsDAO;
import com.SEP7.ToolBeer.localDatabase.DAO.IRSetup;
import com.SEP7.ToolBeer.localDatabase.DAO.ProductsDAO;
import com.SEP7.ToolBeer.localDatabase.DAO.UsersDAO;
import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;
import com.SEP7.ToolBeer.localDatabase.Entity.Favorits;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;
import com.SEP7.ToolBeer.localDatabase.Entity.Users;
import com.SEP7.ToolBeer.localDatabase.ProductsDatabase;

import java.beans.PropertyChangeSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository implements IRProducts, IRUsers, IRFavorits, IRDistributors, IRSetup {

    private final ProductsDAO productsDAO;
    private final DistributorsDAO distributorsDAO;
    private final FavoritsDAO favoritsDAO;
    private final UsersDAO usersDAO;

    private ExecutorService executerservice;
    private final Handler mainThreadHandler;
    private PropertyChangeSupport propertychangesupport;
    private static Repository instance;


    private List<Products> productslist;
    private List<Distributors> distributorslist;
    private List<Products> favoritslist;

    private UserRepository userRepository;
    private Users activuser;

    private Repository(Application app) {
        Executors.newFixedThreadPool(4);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
        productsDAO = ProductsDatabase.getInstance(app).productsDao();
        distributorsDAO = null;
        favoritsDAO = null;
        usersDAO = null;
    }

    @Override
    public void setActivUser() {
        userRepository = UserRepository.getInstance();
        activuser.setUserID(userRepository.getCurrentUser().getValue().getUid());
    }

    public static Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }

    public void callbackProduct(List<Products> productslist) {
        this.productslist = productslist;
        propertychangesupport.firePropertyChange("eventProducts",null,productslist);
    }


    private void callbackFavortis(List<Products> favprods) {
        this.favoritslist = favprods;
        propertychangesupport.firePropertyChange("eventFavorits",null,favoritslist);
    }

    private void callbackDistributors(List<Distributors> ds) {
        this.distributorslist = ds;
        propertychangesupport.firePropertyChange("eventDistributors",null,distributorslist);
    }

    @Override
    public void getProducts() {
        executerservice.execute(() -> {
            List<Products> ps = productsDAO.getAllProducts();
            mainThreadHandler.post(() ->callbackProduct(ps));
        });
    }

    @Override
    public void getDistributors() {
        executerservice.execute(() -> {
            List<Distributors> ds = distributorsDAO.getAllDistributors();
            mainThreadHandler.post(() ->callbackDistributors(ds));
        });
    }

    @Override
    public void getFavorits() {
        executerservice.execute(() -> {
            List<Favorits> fs = favoritsDAO.getAllFavorits(activuser.getUserID());
            List<Products> ps = productsDAO.getAllProducts();
            List<Products> favProd = new ArrayList<>();
            //det her er virkelig slemt og grimt, men kun fordi vi ikke har en ralationel database. I en virkelig database kan dette fixes meget mere elegant med en join
            for(Favorits f : fs) {
                for (Products p : ps) {
                    if (f.getProtID() == p.getProtID()) {
                        favProd.add(p);
                    }
                }
            }
            mainThreadHandler.post(() ->callbackFavortis(favProd));
        });
    }

    @Override
    public void addFavorit(int prodID) {
        executerservice.execute(() -> {
           favoritsDAO.addFavorit(prodID, activuser.getUserID());
        });
    }
}