package com.androidaflevering.smartpark.ui.indstillinger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IndstillingerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IndstillingerViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}