package com.SEP7.ToolBeer.data.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.os.HandlerCompat;

import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRDistributors;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRFavorits;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRProducts;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRUsers;

import com.SEP7.ToolBeer.localDatabase.DAO.DistributorsDAO;
import com.SEP7.ToolBeer.localDatabase.DAO.FavoritsDAO;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRSetup;
import com.SEP7.ToolBeer.localDatabase.DAO.ProductsDAO;
import com.SEP7.ToolBeer.localDatabase.DAO.UsersDAO;
import com.SEP7.ToolBeer.localDatabase.DistributorsDatabase;
import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;
import com.SEP7.ToolBeer.localDatabase.Entity.Favorits;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;
import com.SEP7.ToolBeer.localDatabase.Entity.Users;
import com.SEP7.ToolBeer.localDatabase.FavoritsDatabase;
import com.SEP7.ToolBeer.localDatabase.ProductsDatabase;
import com.SEP7.ToolBeer.localDatabase.Seed;
import com.SEP7.ToolBeer.localDatabase.UsersDatabase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

    private final ExecutorService executerservice;
    private final Handler mainThreadHandler;
    private final PropertyChangeSupport propertychangesupport;
    private static Repository instance;

    private List<Products> productslist;
    private List<Distributors> distributorslist;
    private List<Products> favoritslist;

    private UserRepository userRepository;
    private final Seed seed;
    private final Users activuser;

    private Repository(Application app) {
        executerservice = Executors.newFixedThreadPool(6);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
        propertychangesupport = new PropertyChangeSupport(this);
        productsDAO = ProductsDatabase.getInstance(app).productsDao();
        distributorsDAO = DistributorsDatabase.getInstance(app).distributorsDAO();
        favoritsDAO = FavoritsDatabase.getInstance(app).favoritsDAO();
        usersDAO = UsersDatabase.getInstance(app).usersDao();
        seed = Seed.getInstance();
        activuser = new Users("tempstring", 18, null, null);
        //temp user data to protect against null pointer exeptions

        //comment this in to seed the local database
        //seed();
    }

    @Override
    public void setActivUser() {
        userRepository = UserRepository.getInstance();
        executerservice.execute(()-> {
            activuser.setUserID(userRepository.getCurrentUser().getValue().getUid());
            usersDAO.insert(activuser);
        });
    }

    @Override
    public void loadData() {
        executerservice.execute(() -> {
            List<Products> ps = productsDAO.getAllProducts();
            mainThreadHandler.post(() ->callbackProduct(ps));
        });
        executerservice.execute(() -> {
            List<Distributors> ds =
                    distributorsDAO.getAllDistributors();
            mainThreadHandler.post(() -> callbackDistributors(ds));
        });
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
    public List<Products> getProducts() {
        return productslist;
    }

    @Override
    public void collectProducts() {
        executerservice.execute(() -> {
            List<Products> ps = productsDAO.getAllProducts();
            mainThreadHandler.post(() ->callbackProduct(ps));
        });
    }

    @Override
    public void collectDistributors() {
        executerservice.execute(() -> {
            List<Distributors> ds =
                    distributorsDAO.getAllDistributors();
            mainThreadHandler.post(() -> callbackDistributors(ds));
        });
    }

    @Override
    public ArrayList<Distributors> getDistributors() {
        return (ArrayList<Distributors>)distributorslist;
    }

    @Override
    public void collectFavorits() {
        executerservice.execute(() -> {
            List<Favorits> fs = favoritsDAO.getAllFavorits(activuser.getUserID());
            List<Products> favProd = new ArrayList<>();
            for(Favorits f : fs) {
                for (Products p : productslist) {
                    if (f.getProtID() == p.getProtID()) {
                        favProd.add(p);
                    }
                }
            }
            mainThreadHandler.post(() ->callbackFavortis(favProd));
        });
    }

    @Override
    public ArrayList<Products> getFavorits() {
        return (ArrayList<Products>) favoritslist;
    }

    @Override
    public void addFavorit(int prodID) {
        executerservice.execute(() -> {
           favoritsDAO.addFavorit(prodID, activuser.getUserID());
        });
    }


    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertychangesupport.addPropertyChangeListener(name, listener);
        switch (name) {
            case "eventProducts":
                listener.propertyChange(new PropertyChangeEvent(this, "eventProducts",null,productslist));
                break;
            case "eventFavorits":
                listener.propertyChange(new PropertyChangeEvent(this, "eventFavorits",null,favoritslist));
                break;
            case "eventDistributors":
                listener.propertyChange(new PropertyChangeEvent(this, "eventDistributors",null,distributorslist));
                break;
            default:
                Log.d("call", "Der var en fejl i propertychangelistner");
                break;
        }
    }

       private void seed() {
        executerservice.execute(() -> {
                    ArrayList<Products> temp = seed.getProducts();
                    for(Products p : temp) {
                        productsDAO.insert(p);
                    }
                }
        );
        executerservice.execute(() -> {
                    ArrayList<Distributors> temp = seed.getForhandlereAListe();
                    for(Distributors d : temp) {
                        distributorsDAO.insert(d);
                    }
                }
        );
           executerservice.execute(() -> {
                       Favorits favorit = new Favorits(2,activuser.getUserID());
                           favoritsDAO.insert(favorit);
                   }
           );
    }
}