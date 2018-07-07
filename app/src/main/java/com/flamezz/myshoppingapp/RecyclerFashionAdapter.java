package com.flamezz.myshoppingapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerFashionAdapter extends RecyclerView.Adapter<RecyclerFashionAdapter.RecyclerViewHolder> {

    ArrayList<FashAndGroc> arrayList;
    RecyclerFashionAdapter(ArrayList<FashAndGroc> arrayList)
    {
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_fashion,parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        FashAndGroc fashAndGroc =  arrayList.get(position);
        holder.textViewName.setText(fashAndGroc.getItemName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        RecyclerViewHolder(View view)
        {
            super(view);
            textViewName = view.findViewById(R.id.textViewCategory);
        }
    }
}
