package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Schedules.BusSchedule;
import com.CollegeTimeDevelopers.Mysuru.R;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    Context context;
    List<BusSchedule> busList;

    public BusAdapter(Context context, List<BusSchedule> busList) {
        this.context = context;
        this.busList = busList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_place_details_bus, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.busNumber.setText(String.valueOf(busList.get(position).getBusNumber()));
        holder.destinationName.setText(busList.get(position).getBusDestination());
        holder.time.setText(busList.get(position).getTime());
    }


    @Override
    public int getItemCount() {
        return busList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView time, destinationName, busNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            time = itemView.findViewById(R.id.layout_bus_time);
            destinationName = itemView.findViewById(R.id.layout_bus_destination);
            busNumber = itemView.findViewById(R.id.layout_bus_number);
        }


    }
}