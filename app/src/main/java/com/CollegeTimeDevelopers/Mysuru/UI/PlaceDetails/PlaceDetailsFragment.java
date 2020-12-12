package com.CollegeTimeDevelopers.Mysuru.UI.PlaceDetails;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.CollegeTimeDevelopers.Mysuru.Adapters.HotelsNearByAdapter;
import com.CollegeTimeDevelopers.Mysuru.Adapters.PlaceDetailsSouvenirRecyclerAdapter;
import com.CollegeTimeDevelopers.Mysuru.Adapters.PlaceDetailsViewpagerAdapter;
import com.CollegeTimeDevelopers.Mysuru.Common.Common;
import com.CollegeTimeDevelopers.Mysuru.Models.Places;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlaceDetailsFragment extends Fragment {
    View root;
    Unbinder unbinder;
    private PlaceDetailsViewModel mViewModel;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_view_pager)
    ViewPager2 viewPager2;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_place_name)
    TextView placeName;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_place_open_close)
    TextView openCloseTime;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_place_navigation)
    ImageView placeNavigation;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_recycler_souvenirs)
    RecyclerView souvenir_recycler_view;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_place_description)
    TextView placeDescription;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.place_details_recycler_hotels_near_me)
    RecyclerView hotels_near_by_recycler_view;

@BindView(R.id.place_details_dot)
        TabLayout tabLayout;



    Places selectedPlace;
    KenBurnsView kbv;
    boolean moving =true;
    public static PlaceDetailsFragment newInstance() {
        return new PlaceDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         root = inflater.inflate(R.layout.place_details_fragment, container, false);
        unbinder =  ButterKnife.bind(this,root);
        init();

        return root;
    }
    @SuppressLint("SetTextI18n")
    void init(){
        selectedPlace  = Common.CURRENT_SELECTED_PLACE;
        //Settinf Up Souvenir
        souvenir_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        souvenir_recycler_view.setAdapter(new PlaceDetailsSouvenirRecyclerAdapter(getContext(),selectedPlace.getSouvenir().getItems()));

        //Setting Up Hotels

        hotels_near_by_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        hotels_near_by_recycler_view.setAdapter(new HotelsNearByAdapter(getContext(),selectedPlace.getNearBy().getHotels().getList()));


        viewPager2.setAdapter(new PlaceDetailsViewpagerAdapter(getContext(),selectedPlace.getImageUrl()));

        placeName.setText(selectedPlace.getFmaousName());
        openCloseTime.setText(selectedPlace.getOpeningTime()+"-"+selectedPlace.getClosingTime());
        placeDescription.setText(selectedPlace.getLongDescription());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        kbv = (KenBurnsView) getActivity().findViewById(R.id.place_details_kbv);
        kbv.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                    tabLayout.setVisibility(View.VISIBLE);
                    kbv.setVisibility(View.GONE);
                    viewPager2.setVisibility(View.VISIBLE);
            }
        });


        Glide.with(Objects.requireNonNull(getContext())).load(selectedPlace.getImageUrl().get(0)).into(kbv);

//        AccelerateDecelerateInterpolator adi = new AccelerateDecelerateInterpolator();
//        RandomTransitionGenerator generator = new RandomTransitionGenerator(5000, adi);
//        kbv.setTransitionGenerator(generator);


        kbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moving) {
                    kbv.pause();
                    moving = false;
                } else {
                    kbv.resume();
                    moving = true;
                }
            }
        });


        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();


//        kbv.setTransitionListener(new KenBurnsView.TransitionListener() {
//                    @Override
//                    public void onTransitionStart(Transition transition) {
//
//                    }
//
//                    @Override
//                    public void onTransitionEnd(Transition transition)
//                    {
//
//                        kbv.setVisibility(View.GONE);
//                        viewPager2.setVisibility(View.VISIBLE);
//                    }
//                });
        mViewModel = new ViewModelProvider(this).get(PlaceDetailsViewModel.class);

    }
    @Override
    public void onStop() {
        super.onStop();

        try {
            unbinder.unbind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}