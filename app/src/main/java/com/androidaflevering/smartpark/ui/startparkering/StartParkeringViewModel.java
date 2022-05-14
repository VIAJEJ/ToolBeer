package com.androidaflevering.smartpark.ui.startparkering;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StartParkeringViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public StartParkeringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}