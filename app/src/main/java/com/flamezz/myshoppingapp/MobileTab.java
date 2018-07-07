package com.flamezz.myshoppingapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MobileTab extends Fragment {

    private ArrayList<ItemDescription> arrayList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance) {
        View view = inflater.inflate(R.layout.mobiletab, container, false);

        arrayList = new ArrayList<>();
       RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerMobileAdapter adapter = new RecyclerMobileAdapter(arrayList, new onClickListener() {
            @Override
            public void onClick(String name, String price,int image) {
                Intent intent = new Intent(getContext(),PurchaseActivity.class);
                intent.putExtra("NAME",name);
                intent.putExtra("PRICE",price);
                intent.putExtra("IMAGE",image);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        fillarrayListMobile();
        return view;
    }

    public void fillarrayListMobile()
    {
        ItemDescription itemDescription = new ItemDescription();
       itemDescription.setImage(R.drawable.huawei);
       itemDescription.setName("HUAWEI P20 PRO");
       itemDescription.setPrice( "64,999");
        arrayList.add(itemDescription);

        ItemDescription itemDescription2 = new ItemDescription();
        itemDescription2.setImage(R.drawable.samsungs9);
        itemDescription2.setName("SAMSUNG GALAXY S9");
        itemDescription2.setPrice( "53,950");
        arrayList.add(itemDescription2);


        ItemDescription itemDescription3 = new ItemDescription();
        itemDescription3.setImage(R.drawable.iphonex);
        itemDescription3.setName("APPLE IPHONE X");
        itemDescription3.setPrice( "97,500");
        arrayList.add(itemDescription3);

        ItemDescription itemDescription4 = new ItemDescription();
        itemDescription4.setImage(R.drawable.lg);
        itemDescription4.setName(" LG G7 THINQ");
        itemDescription4.setPrice( "27,990");
        arrayList.add(itemDescription4);


        ItemDescription itemDescription5 = new ItemDescription();
        itemDescription5.setImage(R.drawable.samsungnote8);
        itemDescription5.setName("SAMSUNG GALAXY NOTE 8");
        itemDescription5.setPrice( "55,900");
        arrayList.add(itemDescription5);

        ItemDescription itemDescription6 = new ItemDescription();
        itemDescription6.setImage(R.drawable.pixel2);
        itemDescription6.setName("PIXEL 2 XL");
        itemDescription6.setPrice( "52,194");
        arrayList.add(itemDescription6);

        ItemDescription itemDescription7 = new ItemDescription();
        itemDescription7.setImage(R.drawable.oneplus6);
        itemDescription7.setName("ONE PLUS 6");
        itemDescription7.setPrice("39,999");
        arrayList.add(itemDescription7);

    }

}
