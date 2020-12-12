package com.CollegeTimeDevelopers.Mysuru.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CollegeTimeDevelopers.Mysuru.Models.Souvenir.Items;
import com.CollegeTimeDevelopers.Mysuru.Models.Souvenir.Souvenir;
import com.CollegeTimeDevelopers.Mysuru.Models.UI.Home.Glimpses;
import com.CollegeTimeDevelopers.Mysuru.R;
import com.bumptech.glide.Glide;


import java.util.List;

public class PlaceDetailsSouvenirRecyclerAdapter extends RecyclerView.Adapter<PlaceDetailsSouvenirRecyclerAdapter.ViewHolder> {
    Context context;
    List<Items> souvenirList;

    public PlaceDetailsSouvenirRecyclerAdapter(Context context, List<Items> souvenirList) {
        this.context = context;
        this.souvenirList = souvenirList;
    }

    @NonNull
    @Override
    public PlaceDetailsSouvenirRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceDetailsSouvenirRecyclerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_place_details_souvenir_item,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PlaceDetailsSouvenirRecyclerAdapter.ViewHolder holder, int position) {
        holder.itemName_Price.setText(souvenirList.get(position).getName()+"  "+souvenirList.get(position).getPriceRange());
        Glide.with(context).load(souvenirList.get(position).getImageUrl()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return souvenirList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName_Price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.place_details_souvenir_item_image);
            itemName_Price = itemView.findViewById(R.id.place_details_souvenir_item_name_price);
        }
    }
}
