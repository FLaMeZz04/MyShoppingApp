package com.flamezz.myshoppingapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerMobileAdapter extends RecyclerView.Adapter<RecyclerMobileAdapter.RecyclerViewHolder> {

    private ArrayList<ItemDescription> arrayList;
    private onClickListener listener;
    RecyclerMobileAdapter(ArrayList<ItemDescription> arrayList,onClickListener listener)
    {
        this.arrayList=arrayList;
        this.listener=listener;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_mobile,parent,false);
        RecyclerViewHolder viewHolderr = new RecyclerViewHolder(view);
        return viewHolderr;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        final ItemDescription itemDescription = arrayList.get(position);
        holder.mobileImage.setImageResource(itemDescription.getImage());
        holder.mobileName.setText(itemDescription.getName());
        holder.mobilePrice.setText(itemDescription.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(arrayList.get(position).getName(),arrayList.get(position).getPrice(),arrayList.get(position).getImage());
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
         ImageView mobileImage;
         TextView mobileName,mobilePrice;
        RecyclerViewHolder(View mview) {
            super(mview);

            mobileImage = mview.findViewById(R.id.imageView);
            mobileName = mview.findViewById(R.id.mobileName);
            mobilePrice = mview.findViewById(R.id.mobilePrice);
        }

    }
}
