package com.CollegeTimeDevelopers.Mysuru.UI.PlaceDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.CollegeTimeDevelopers.Mysuru.Models.Places;

public class PlaceDetailsViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    MutableLiveData<Places>selected_palce;

    public MutableLiveData<Places> getSelected_palce() {
        return selected_palce;
    }

    public void setSelected_palce(MutableLiveData<Places> selected_palce) {
        this.selected_palce = selected_palce;
    }
}