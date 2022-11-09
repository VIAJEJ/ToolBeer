package com.SEP7.ToolBeer.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.SEP7.ToolBeer.data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public MainActivityViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);

    }

    public void init() {
        String userId = Objects.requireNonNull(userRepository.getCurrentUser().getValue()).getUid();
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }


    public void signOut() {
        userRepository.signOut();
    }
}
