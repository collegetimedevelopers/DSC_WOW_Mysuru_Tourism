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

import com.CollegeTimeDevelopers.Mysuru.Adapters.HomeHotelNearBy;
import com.CollegeTimeDevelopers.Mysuru.Adapters.HotelsNearByAdapter;
import com.CollegeTimeDevelopers.Mysuru.Models.HotelModel;
import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists.HotelList;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelFragment extends Fragment {

    private HotelViewModel mViewModel;

    RecyclerView hotel_recycler , resturant_recycler;
    List<HotelModel>resturantList;
    List<HotelModel> hotelsList;

    public static HotelFragment newInstance() {
        return new HotelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // getActivity().setTheme(R.);
        return inflater.inflate(R.layout.hotel_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HotelViewModel.class);

        resturant_recycler = getActivity().findViewById(R.id.hotel_recycler_restaurant);

        hotel_recycler = getActivity().findViewById(R.id.hotel_recycler_hotel);


        loadHotelDataFromFirebase();
        loadResturantDataFromFirebase();
    }

    public  void loadHotelDataFromFirebase()
    {
        hotelsList = new ArrayList<>();
     //


        FirebaseDatabase.getInstance().getReference().child("Hotels").orderByChild("category").equalTo("hotel")
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    for(DataSnapshot data :snapshot.getChildren())
                    {

                        HotelModel hotels = new HotelModel();
                        hotels = data.getValue(HotelModel.class);
                        hotels.setName(data.getKey());

                        hotelsList.add(hotels);

                       // System.out.println("data form fb = "+hotels.getName());

                    }

                    setHotelsAdapterAdapter();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


public  void  loadResturantDataFromFirebase()
{
    resturantList = new ArrayList<>();

    FirebaseDatabase.getInstance().getReference().child("Hotels").orderByChild("category").equalTo("restaurant").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.exists())
            {
                for(DataSnapshot data :snapshot.getChildren())
                {

                    HotelModel hotels = new HotelModel();
                    hotels = data.getValue(HotelModel.class);
                    hotels.setName(data.getKey());

                    resturantList.add(hotels);

                    System.out.println("data form fb = "+hotels.getName());

                }

                setResturantAdapterAdapter();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
}



    public void setHotelsAdapterAdapter()
    {


        HomeHotelNearBy homeHotelNearBy = new HomeHotelNearBy(getContext(),hotelsList);
        ////HomeHotel hotelsNearByAdapter = new HotelsNearByAdapter(getContext(), hotelsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        hotel_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hotel_recycler.setHasFixedSize(true);
        hotel_recycler.setAdapter(homeHotelNearBy);

        System.out.println("setting adapter = ");

        try {

            hotel_recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void setResturantAdapterAdapter()
    {


        HomeHotelNearBy homeHotelNearBy = new HomeHotelNearBy(getContext(),hotelsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        resturant_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        resturant_recycler.setHasFixedSize(true);
        resturant_recycler.setAdapter(homeHotelNearBy);

        System.out.println("setting adapter = ");

        try {

            resturant_recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}