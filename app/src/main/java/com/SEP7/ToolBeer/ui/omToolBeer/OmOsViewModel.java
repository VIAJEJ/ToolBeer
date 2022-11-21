package com.SEP7.ToolBeer.ui.omToolBeer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OmOsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OmOsViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}