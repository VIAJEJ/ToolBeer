package com.SEP7.ToolBeer.ui.findForhandler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Find_Forhandler_ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Find_Forhandler_ViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}