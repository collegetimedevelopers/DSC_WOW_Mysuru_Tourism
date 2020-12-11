package com.CollegeTimeDevelopers.Mysuru.UI.PlaceDetails;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;

import java.util.Objects;

public class PlaceDetailsFragment extends Fragment {

    private PlaceDetailsViewModel mViewModel;

    KenBurnsView kbv;
    boolean moving =true;
    public static PlaceDetailsFragment newInstance() {
        return new PlaceDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.place_details_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        kbv = (KenBurnsView) getActivity().findViewById(R.id.place_details_kbv);


        Glide.with(Objects.requireNonNull(getContext())).load("https://media.gettyimages.com/photos/maharajas-palace-at-night-india-picture-id470216784?k=6&m=470216784&s=612x612&w=0&h=X9DCMmeH3GIH4nP9mXso-gfkzKRrhSV5K6-jq64gd3Q=").into(kbv);

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
//                        kbv.pause();
//                    }
//                });
        mViewModel = new ViewModelProvider(this).get(PlaceDetailsViewModel.class);

    }

}