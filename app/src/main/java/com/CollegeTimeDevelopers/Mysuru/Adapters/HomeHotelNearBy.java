package com.CollegeTimeDevelopers.Mysuru.Adapters;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.HotelModel;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeHotelNearBy extends RecyclerView.Adapter<HomeHotelNearBy.ViewHolder>
{

    Context context;
    List<HotelModel> hotelLists;

    public HomeHotelNearBy(Context context, List<HotelModel> hotelLists) {
        this.context = context;
        this.hotelLists = hotelLists;

        System.out.println("in adapter = ");

    }

    @NonNull
    @Override
    public HomeHotelNearBy.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_home_hotels_nearby, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHotelNearBy.ViewHolder holder, int position)
    {
        Glide.with(context).load(hotelLists.get(position).getImageURL().get(0)).into(holder.hotelImage);

        holder.hotelName.setText(hotelLists.get(position).getName());

        holder.hotelPriceRange.setText(hotelLists.get(position).getPriceRange());


    }

    @Override
    public int getItemCount() {
        return hotelLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImage;
        TextView hotelName,hotelPriceRange;
     //   TextView priceRange;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImage = itemView.findViewById(R.id.layout_home_hotel_nearby_img);
            hotelName = itemView.findViewById(R.id.layout_home_hotel_nearby_name);
            hotelPriceRange = itemView.findViewById(R.id.layout_home_hotel_nearby_price);

        }
    }
}

