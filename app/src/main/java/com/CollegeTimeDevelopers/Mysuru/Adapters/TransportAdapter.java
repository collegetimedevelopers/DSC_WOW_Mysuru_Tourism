package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.Railway;
import com.CollegeTimeDevelopers.Mysuru.R;

import java.time.MonthDay;
import java.util.List;

public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder> {

    Context context;
    List<Railway> trainList;

    public TransportAdapter(Context context, List<Railway> trainList) {
        this.context = context;
        this.trainList = trainList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransportAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_transport_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.source.setText(trainList.get(position).getTrainSource());
        holder.destination.setText(trainList.get(position).getTrainDestination());
        holder.arrivalTime.setText(trainList.get(position).getArrival());
        holder.destinationTime.setText(trainList.get(position).getDeparture());
        holder.trainNumber.setText(String.valueOf(trainList.get(position).getTrainNumber()));
        holder.trainName.setText(trainList.get(position).getTrainName());

        String runsInWeek = null;
        try {
            runsInWeek = trainList.get(position).getRunsWeekDays();
        } catch (Exception e) {
            System.out.println("Position = "+position);
            e.printStackTrace();
        }


       holder.monday.setPaintFlags(holder.monday.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
       // holder.monday.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        try {
            if (runsInWeek.contains("Sn"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
            else if(runsInWeek.contains("M"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
            else if(runsInWeek.contains("T"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
            else if(runsInWeek.contains("W"))
            { holder.monday.setTextColor(Color.parseColor("#16DA49"));

            }
            else if(runsInWeek.contains("Th"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
            else if(runsInWeek.contains("F"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
            else if(runsInWeek.contains("St"))
            {
                holder.monday.setTextColor(Color.parseColor("#16DA49"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView source , destination , arrivalTime ,destinationTime ,monday ,tuesday,wednesday, thursday,friday,saturday ,sunday, trainNumber , trainName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            source = itemView.findViewById(R.id.transport_recycler_train_source);
            destination = itemView.findViewById(R.id.transport_recycler_train_dest);
            arrivalTime = itemView.findViewById(R.id.transport_recycler_train_s_time);
            destinationTime = itemView.findViewById(R.id.transport_recycler_train_dest_time);
trainNumber = itemView.findViewById(R.id.transport_recycler_train_numb);
trainName = itemView.findViewById(R.id.transport_recycler_train_name);

monday = itemView.findViewById(R.id.transport_recycler_day_monday);
tuesday= itemView.findViewById(R.id.transport_recycler_day_tuesday);
wednesday = itemView.findViewById(R.id.transport_recycler_day_wednesday);

thursday = itemView.findViewById(R.id.transport_recycler_day_thursday);
friday = itemView.findViewById(R.id.transport_recycler_day_friday);
saturday= itemView.findViewById(R.id.transport_recycler_day_saturday);
sunday = itemView.findViewById(R.id.transport_recycler_day_sunday);
        }
    }
}