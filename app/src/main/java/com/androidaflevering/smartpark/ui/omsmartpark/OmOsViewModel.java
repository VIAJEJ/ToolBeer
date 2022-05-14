package com.androidaflevering.smartpark.ui.omsmartpark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OmOsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OmOsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}