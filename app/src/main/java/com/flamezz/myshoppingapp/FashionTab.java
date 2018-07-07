package com.flamezz.myshoppingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FashionTab extends Fragment {
    private ArrayList<FashAndGroc> arrayList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fashiontab, container, false);
        arrayList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerFashionAdapter adapter = new RecyclerFashionAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        fillArrayListFashion();

        return view;
    }
    public void fillArrayListFashion()
    {
        FashAndGroc fashAndGroc = new FashAndGroc();
        fashAndGroc.setItemName("MEN'S CLOTHING");
        arrayList.add(fashAndGroc);

        FashAndGroc fashAndGroc1 = new FashAndGroc();
        fashAndGroc1.setItemName("WOMEN'S CLOTHING");
        arrayList.add(fashAndGroc1);

        FashAndGroc fashAndGroc2 = new FashAndGroc();
        fashAndGroc2.setItemName("KID'S ClOTHING");
        arrayList.add(fashAndGroc2);

        FashAndGroc fashAndGroc3 = new FashAndGroc();
        fashAndGroc3.setItemName("WATCHES");
        arrayList.add(fashAndGroc3);

        FashAndGroc fashAndGroc4 = new FashAndGroc();
        fashAndGroc4.setItemName("MEN'S SHOES");
        arrayList.add(fashAndGroc4);

        FashAndGroc fashAndGroc5 = new FashAndGroc();
        fashAndGroc5.setItemName("WOMEN'S SHOES");
        arrayList.add(fashAndGroc5);

        FashAndGroc fashAndGroc6 = new FashAndGroc();
        fashAndGroc6.setItemName("BACKPACKS");
        arrayList.add(fashAndGroc6);

        FashAndGroc fashAndGroc7 = new FashAndGroc();
        fashAndGroc7.setItemName("HANDBAGS");
        arrayList.add(fashAndGroc7);





    }
}
