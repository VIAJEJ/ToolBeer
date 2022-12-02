package com.SEP7.ToolBeer.data.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.SEP7.ToolBeer.data.UserLiveData;
import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;
import com.SEP7.ToolBeer.localDatabase.Seed;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class UserRepository {
    private final UserLiveData currentUser;
    private final Application app;
    private static UserRepository instance;

    private UserRepository(Application app) {
        this.app = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app) {
        if(instance == null)
            instance = new UserRepository(app);
        return instance;
    }

    public static synchronized UserRepository getInstance() {
        if(instance != null) {
            return instance;
        }
        return null;
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return currentUser;
    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(app.getApplicationContext());
    }
}
