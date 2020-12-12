package com.CollegeTimeDevelopers.Mysuru.UI.Hotel;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.CollegeTimeDevelopers.Mysuru.R;

public class HotelFragment extends Fragment {

    private HotelViewModel mViewModel;

    public static HotelFragment newInstance() {
        return new HotelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hotel_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HotelViewModel.class);
        // TODO: Use the ViewModel
    }

}