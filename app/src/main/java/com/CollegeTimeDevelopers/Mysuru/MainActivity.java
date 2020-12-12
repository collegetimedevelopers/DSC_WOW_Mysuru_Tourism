package com.CollegeTimeDevelopers.Mysuru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.CollegeTimeDevelopers.Mysuru.Common.Common;
import com.CollegeTimeDevelopers.Mysuru.EventBus.TopAttractionClickEvent;
import com.CollegeTimeDevelopers.Mysuru.UI.Emergency.Emergency;
import com.CollegeTimeDevelopers.Mysuru.UI.Home.HomeFragment;
import com.CollegeTimeDevelopers.Mysuru.UI.Hotel.HotelFragment;
import com.CollegeTimeDevelopers.Mysuru.UI.PlaceDetails.PlaceDetailsFragment;
import com.CollegeTimeDevelopers.Mysuru.UI.Transport.TransportFragment;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        // Guide , Hotel

        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_SHIFTING);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_baseline_emergency_24, "Emergency").setActiveColor("#CC1418").setInActiveColor("#CC1418"))
                .addItem(new BottomNavigationItem(R.drawable.ic_outline_directions_railway_24, "Transport").setActiveColor("#3336E3").setInActiveColor("#3336E3"))
                .addItem(new BottomNavigationItem(R.drawable.ic_baseline_tour_24, "Home").setActiveColor("#121111").setInActiveColor("#FFFFFF"))
                .addItem(new BottomNavigationItem(R.drawable.ic_baseline_hotel_24, "Hotel").setActiveColor("#989898").setInActiveColor("#10FFFF"))
                .addItem(new BottomNavigationItem(R.drawable.ic_guide_24, "Guide").setActiveColor("#530267").setInActiveColor("#b000bf"))

                .setFirstSelectedPosition(2)
                .initialise();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Emergency()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TransportFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HotelFragment()).commit();
                        break;


                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = false)
    public void topAttractionPlacesClicked(TopAttractionClickEvent event) {
        if (event.isSuccess()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlaceDetailsFragment()).commit();
            Common.CURRENT_FRAGMENT = 1;
        }
    }

    @Override
    public void onBackPressed() {
        if (Common.CURRENT_FRAGMENT == 1) {
            getSupportFragmentManager().popBackStack();
            Common.CURRENT_FRAGMENT = 0;
        } else {
            super.onBackPressed();
        }
    }
}