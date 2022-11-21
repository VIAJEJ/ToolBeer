package com.SEP7.ToolBeer.ui.forhandlere;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForhandlereViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ForhandlereViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}