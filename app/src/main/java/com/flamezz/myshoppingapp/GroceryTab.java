package com.flamezz.myshoppingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GroceryTab extends Fragment {
    private ArrayList<FashAndGroc> arrayList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.grocerytab, container, false);
        arrayList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerFashionAdapter adapter = new RecyclerFashionAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        fillArrayListGrocery();
        return view;
    }

    public void fillArrayListGrocery()
    {
        FashAndGroc fashAndGroc = new FashAndGroc();
        fashAndGroc.setItemName("COOKING ESSENTIALS");
        arrayList.add(fashAndGroc);

        FashAndGroc fashAndGroc1 = new FashAndGroc();
        fashAndGroc1.setItemName("PACKAGED FOODS");
        arrayList.add(fashAndGroc1);

        FashAndGroc fashAndGroc2 = new FashAndGroc();
        fashAndGroc2.setItemName("SNACK FOODS");
        arrayList.add(fashAndGroc2);

        FashAndGroc fashAndGroc3 = new FashAndGroc();
        fashAndGroc3.setItemName("BEVERAGES");
        arrayList.add(fashAndGroc3);

        FashAndGroc fashAndGroc4 = new FashAndGroc();
        fashAndGroc4.setItemName("HOUSEHOLD SUPPLIES");
        arrayList.add(fashAndGroc4);

        FashAndGroc fashAndGroc5 = new FashAndGroc();
        fashAndGroc5.setItemName("HAIRCARE,BATH & BODY");
        arrayList.add(fashAndGroc5);

        FashAndGroc fashAndGroc6 = new FashAndGroc();
        fashAndGroc6.setItemName("SKINCARE & MAKEUP");
        arrayList.add(fashAndGroc6);

        FashAndGroc fashAndGroc7 = new FashAndGroc();
        fashAndGroc7.setItemName("PERSONAL CARE");
        arrayList.add(fashAndGroc7);
    }
}
