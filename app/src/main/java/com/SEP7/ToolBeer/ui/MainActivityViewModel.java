package com.SEP7.ToolBeer.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.data.Repository.UserRepository;
import com.SEP7.ToolBeer.localDatabase.DAO.IRSetup;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private IRSetup repository;

    public MainActivityViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);

        repository = Repository.getInstance(app);
        repository.setActivUser();
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
