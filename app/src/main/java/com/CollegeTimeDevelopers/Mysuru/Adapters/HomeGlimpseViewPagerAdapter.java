package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.UI.Home.Glimpses;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeGlimpseViewPagerAdapter extends RecyclerView.Adapter<HomeGlimpseViewPagerAdapter.PageHolder> {

    List<Glimpses> glimpsesList;
    Context context;

    public HomeGlimpseViewPagerAdapter(@NonNull List<Glimpses> glimpsesList, Context context) {
        this.glimpsesList = glimpsesList;
        this.context = context;
    }

    @NotNull
    @Override
    public PageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PageHolder(LayoutInflater.from(context).inflate(R.layout.layout_home_viewpager_glimpses,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PageHolder holder, int position) {
        holder.place_name.setText(glimpsesList.get(position).getPlaceName());
        Glide.with(context).load(glimpsesList.get(position).getImageUrl()).into(holder.place_image);

    }

    @Override
    public int getItemCount() {
         return glimpsesList.size();
    }

    public static class PageHolder extends RecyclerView.ViewHolder{
        ImageView place_image;
        TextView place_name;
        public PageHolder(@NonNull View itemView) {
            super(itemView);
            place_image = itemView.findViewById(R.id.home_viewPager_glimpses_image);
            place_name = itemView.findViewById(R.id.home_viewPager_glimpses_place_name);
        }
    }
}
