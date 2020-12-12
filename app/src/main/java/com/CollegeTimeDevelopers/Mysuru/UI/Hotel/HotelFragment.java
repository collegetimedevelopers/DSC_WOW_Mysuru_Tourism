package com.CollegeTimeDevelopers.Mysuru.UI.Hotel;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.CollegeTimeDevelopers.Mysuru.Adapters.HotelsNearByAdapter;
import com.CollegeTimeDevelopers.Mysuru.Models.HotelModel;
import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists.HotelList;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelFragment extends Fragment {

    private HotelViewModel mViewModel;

    RecyclerView hotel_recycler;

    List<HotelList> hotelsList;

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



    }
    public  void loadDataFromFirebase()
    {
        hotelsList = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("Hotels").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    for(DataSnapshot data :snapshot.getChildren())
                    {
                        HotelList hotels = new HotelList();
                        hotels = data.getValue(HotelList.class);
                        hotels.setName(data.getKey());

                        hotelsList.add(hotels);

                        System.out.println("data form fb = "+hotels.getName());

                    }

                    //setHotelsNearbyAdapterAdapter();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}