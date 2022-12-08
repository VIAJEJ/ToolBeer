package com.SEP7.ToolBeer.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.data.Repository.UserRepository;
import com.SEP7.ToolBeer.localDatabase.DAO.IRSetup;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;


    public MainActivityViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public void init() {
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }


    public void signOut() {
        userRepository.signOut();
    }
}
