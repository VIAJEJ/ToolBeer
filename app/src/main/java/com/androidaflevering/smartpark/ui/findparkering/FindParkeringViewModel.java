package com.androidaflevering.smartpark.ui.findparkering;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindParkeringViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FindParkeringViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}