package com.androidaflevering.smartpark.ui.mineparkeringer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MineParkeringerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MineParkeringerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}