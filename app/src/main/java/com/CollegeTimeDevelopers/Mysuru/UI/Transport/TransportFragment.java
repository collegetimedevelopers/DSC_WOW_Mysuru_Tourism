package com.CollegeTimeDevelopers.Mysuru.UI.Transport;

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
import android.widget.ProgressBar;

import com.CollegeTimeDevelopers.Mysuru.Adapters.TransportAdapter;
import com.CollegeTimeDevelopers.Mysuru.Models.Railway;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TransportFragment extends Fragment {

    private TransportViewModel mViewModel;

    Unbinder unbinder;
    @BindView(R.id.transport_recycler)
    RecyclerView transport_recycler;

    @BindView(R.id.transport_progress)
    ProgressBar transport_progress;

    List<Railway> railwayList;
    View root;

    public static TransportFragment newInstance() {
        return new TransportFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.transport_fragment, container, false);
        unbinder = ButterKnife.bind(this, root);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mViewModel = new ViewModelProvider(this).get(TransportViewModel.class);

        loadDataFromFirebase();

    }

    private void loadDataFromFirebase() {
        railwayList = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("railway").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Railway railway = new Railway();
                        railway = data.getValue(Railway.class);
                        System.out.println("Number = "+railway.getTrainNumber());
                        System.out.println("RunsWeekDays = "+railway.getRunsWeekDays());
                        railwayList.add(railway);
                    }

                    setTransportAdapter();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setTransportAdapter() {
        transport_progress.setVisibility(View.GONE);
        transport_recycler.setVisibility(View.VISIBLE);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transport_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        transport_recycler.setHasFixedSize(true);

        transport_recycler.setAdapter(new TransportAdapter(getContext(), railwayList));


        try {
            transport_recycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}