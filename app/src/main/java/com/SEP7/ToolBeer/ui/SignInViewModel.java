package com.SEP7.ToolBeer.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.data.Repository.UserRepository;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRSetup;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private final IRSetup repository;

    public SignInViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
        repository = Repository.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }

    public IRSetup getRepository() { return repository;}
}
