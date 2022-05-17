package com.androidaflevering.smartpark.ui.samarbejdspartnere;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SamarbejdspartnereViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SamarbejdspartnereViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}