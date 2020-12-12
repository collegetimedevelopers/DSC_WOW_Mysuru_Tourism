package com.CollegeTimeDevelopers.Mysuru.UI.Home;

import androidx.lifecycle.ViewModelProvider;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;

import io.supercharge.shimmerlayout.ShimmerLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.CollegeTimeDevelopers.Mysuru.Adapters.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.CollegeTimeDevelopers.Mysuru.Adapters.HomeGlimpseViewPagerAdapter;
import com.CollegeTimeDevelopers.Mysuru.Adapters.HomeHotelNearBy;
import com.CollegeTimeDevelopers.Mysuru.Adapters.HotelsNearByAdapter;
import com.CollegeTimeDevelopers.Mysuru.Adapters.TopAttractionsAdapter;
import com.CollegeTimeDevelopers.Mysuru.Models.HotelModel;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists.HotelList;
import com.CollegeTimeDevelopers.Mysuru.Models.Places;
import com.CollegeTimeDevelopers.Mysuru.Models.UI.Home.Glimpses;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    ShimmerTextView shimmerTextView;
    ViewPager2 viewPager;

    RecyclerView hotel_recycler;

List<HotelModel> hotelsList;

    TabLayout tabLayout;
    RecyclerView recycler_top_attraction;

    ShimmerLayout home_shimmer_glimpse;

    List<Places> places;
    List<Glimpses> glimpsesList;

    TopAttractionsAdapter topAttractionsAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel

        tabLayout = getActivity().findViewById(R.id.home_dot);
        viewPager = getActivity().findViewById(R.id.home_viewPager);
        home_shimmer_glimpse = getActivity().findViewById(R.id.home_shimmer_glimpse);

        recycler_top_attraction = (RecyclerView) getActivity().findViewById(R.id.home_recycler_top_attraction);

        hotel_recycler = getActivity().findViewById(R.id.home_recycler_hotel_nearby);

        loadDataFromFirebase();


        home_shimmer_glimpse.startShimmerAnimation();

        shimmerTextView = getActivity().findViewById(R.id.shimmer_tv);
        Shimmer shimmer = new Shimmer();
        shimmer.start(shimmerTextView);

        shimmer.setRepeatCount(1)
                .setDuration(2100)
                .setStartDelay(200)
                .setDirection(Shimmer.ANIMATION_DIRECTION_LTR)
                .setAnimatorListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        shimmerTextView.setTextColor(Color.parseColor("#C1BEBE"));

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        shimmerTextView.setTextColor(Color.parseColor("#A19F9F"));

                    }
                });

        loadGlimpses();

        loadTopAttractionsDataFromFirebase();


    }


    private void loadGlimpses() {
        glimpsesList = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("Glimpses").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot glimpData : snapshot.getChildren()) {

                        Glimpses glimpses = new Glimpses();
                        glimpses = glimpData.getValue(Glimpses.class);

                        System.out.println("Place Name = " + glimpses.getPlaceName());
                        glimpsesList.add(glimpses);
                    }
                    setGlimpsesAdapter();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void loadDataFromFirebase() {
        hotelsList = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("Hotels").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {

                        HotelModel hotels = new HotelModel();
                        hotels = data.getValue(HotelModel.class);
                        hotels.setName(data.getKey());

                        hotelsList.add(hotels);

                        System.out.println("data form fb = " + hotels.getName());

                    }

                    setHotelsNearbyAdapterAdapter();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void loadTopAttractionsDataFromFirebase() {
        places = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("Places").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Places tempPlace = new Places();
                        tempPlace = data.getValue(Places.class);
                        tempPlace.setOriginalName(data.getKey());

                        places.add(tempPlace);

                    }
                    setTopAttractionAdapter();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setTopAttractionAdapter() {
        System.out.println("function above");
        topAttractionsAdapter = new TopAttractionsAdapter(places, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recycler_top_attraction.setLayoutManager(layoutManager);
        recycler_top_attraction.setHasFixedSize(true);
        recycler_top_attraction.setAdapter(topAttractionsAdapter);
        try {

            recycler_top_attraction.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("function below");
    }


    private void setGlimpsesAdapter() {
        HomeGlimpseViewPagerAdapter viewPagerAdapter = new HomeGlimpseViewPagerAdapter(glimpsesList, getContext());

        viewPager.setAdapter(viewPagerAdapter);

        home_shimmer_glimpse.stopShimmerAnimation();
        home_shimmer_glimpse.setVisibility(View.GONE);

        viewPager.setVisibility(View.VISIBLE);


        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();
    }


    public void setHotelsNearbyAdapterAdapter() {


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


}