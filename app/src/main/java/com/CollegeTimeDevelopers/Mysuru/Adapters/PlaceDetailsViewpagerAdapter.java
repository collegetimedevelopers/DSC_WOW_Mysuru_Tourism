package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PlaceDetailsViewpagerAdapter extends RecyclerView.Adapter<PlaceDetailsViewpagerAdapter.PageHolder> {
    Context context;
    List<String>imageUrls;

    public PlaceDetailsViewpagerAdapter(Context context, List<String> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @NonNull
    @Override
    public PlaceDetailsViewpagerAdapter.PageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceDetailsViewpagerAdapter.PageHolder(LayoutInflater.from(context).inflate(R.layout.layout_home_places_details_viewpager,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceDetailsViewpagerAdapter.PageHolder holder, int position) {
        Glide.with(context).load(imageUrls.get(position).toString()).into(holder.placeImage);

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class PageHolder extends  RecyclerView.ViewHolder {
        ImageView placeImage;
        public PageHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.home_place_details_viewpager_image);
        }
    }
}
