package com.rex1997.akb_maps.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to my App.\n\n This app created by me Bina Damareksa, you could also take a look at Profile for more info about me.\n\n Best Regards from me.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}