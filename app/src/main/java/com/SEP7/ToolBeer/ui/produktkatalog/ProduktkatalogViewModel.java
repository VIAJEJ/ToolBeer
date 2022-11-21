package com.SEP7.ToolBeer.ui.produktkatalog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProduktkatalogViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProduktkatalogViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}

