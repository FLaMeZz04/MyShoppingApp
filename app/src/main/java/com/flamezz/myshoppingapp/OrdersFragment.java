package com.flamezz.myshoppingapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersFragment extends Fragment {

    private TextView orderName,orderPrice;
    private ImageView imageViewOrders;
    SharedPreferences sharedPreferences;
    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_orders, container, false);
        orderName = view.findViewById(R.id.orderName);
        orderPrice = view.findViewById(R.id.orderPrice);
        Button cancelOrder = view.findViewById(R.id.buttonCancel);
        imageViewOrders = view.findViewById(R.id.imageViewOrders);
        sharedPreferences = getActivity().getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
        final String name = sharedPreferences.getString("name",null);
        String price = sharedPreferences.getString("price",null);
        int image = sharedPreferences.getInt("image",0);
        orderPrice.setText(price);
        orderName.setText(name);
        imageViewOrders.setImageResource(image);
        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
