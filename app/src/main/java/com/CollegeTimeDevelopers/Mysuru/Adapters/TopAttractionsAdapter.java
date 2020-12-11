package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Common.Common;
import com.CollegeTimeDevelopers.Mysuru.EventBus.TopAttractionClickEvent;
import com.CollegeTimeDevelopers.Mysuru.Models.Places;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;
import com.CollegeTimeDevelopers.Mysuru.Models.Places;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Random;

public class TopAttractionsAdapter extends RecyclerView.Adapter<TopAttractionsAdapter.MyViewHolder> {
    List<Places> placesList;
    Context context;

    public TopAttractionsAdapter(List<Places> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
        System.out.println("Adapter");
    }

    @NonNull
    @Override
    public TopAttractionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TopAttractionsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_home_recycler_top_attractions, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopAttractionsAdapter.MyViewHolder holder, int position) {

        System.out.println("Bind");
        holder.place_name.setText(placesList.get(position).getFmaousName());
        holder.open_close_time.setText(placesList.get(position).getOpeningTime() + " - " + placesList.get(position).getClosingTime());

        Glide.with(context).load(placesList.get(position).getImageUrl().get(0)).into(holder.place_image);
        holder.rating.setText(String.valueOf(placesList.get(position).getRating()));

        holder.navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String geoUri = "http://maps.google.com/maps?q=loc:" + placesList.get(position).getLocation().getLat() + "," +  placesList.get(position).getLocation().getLng() + " (" +  placesList.get(position).getLocation().getLocality() + ")";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView place_image, navigation;
        TextView place_name, open_close_time, rating;
        CardView rate_card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            place_image = itemView.findViewById(R.id.lay_top_attract_place_img);
            place_name = itemView.findViewById(R.id.lay_top_attract_place_name);
            open_close_time = itemView.findViewById(R.id.lay_top_attract_open_close);
            rating = itemView.findViewById(R.id.lay_top_attract_rating_txt);
            rate_card = itemView.findViewById(R.id.lay_top_attract_rate_card);
            navigation = itemView.findViewById(R.id.lay_top_attract_navigation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().post(new TopAttractionClickEvent(true));
                    System.out.println("-------------NEW CLICk ON TOP ATTRACTION");
                    Common.CURRENT_SELECTED_PLACE = placesList.get(getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}
