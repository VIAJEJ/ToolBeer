package com.SEP7.ToolBeer.ui.favoritter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritterViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavoritterViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}

