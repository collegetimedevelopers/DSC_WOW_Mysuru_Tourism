package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists.HotelList;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class HotelsNearByAdapter extends RecyclerView.Adapter<HotelsNearByAdapter.ViewHolder> {
    Context context;
    List<HotelList>hotelLists;

    public HotelsNearByAdapter(Context context, List<HotelList> hotelLists) {
        this.context = context;
        this.hotelLists = hotelLists;

        System.out.println("in adapter = ");

    }

    @NonNull
    @Override
    public HotelsNearByAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotelsNearByAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_nearby_hotels,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsNearByAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(hotelLists.get(position).getImageUrl()).into(holder.hotelImage);

        holder.hotelName.setText(hotelLists.get(position).getName());

        holder.priceRange.setText(hotelLists.get(position).getPriceRange());



    }

    @Override
    public int getItemCount() {
        return hotelLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImage;
        TextView hotelName;
        TextView priceRange;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.hotel_nearby_image);
            hotelName = itemView.findViewById(R.id.hotel_near_by_name);
            priceRange = itemView.findViewById(R.id.hotel_near_by_price_range);
        }
    }
}
