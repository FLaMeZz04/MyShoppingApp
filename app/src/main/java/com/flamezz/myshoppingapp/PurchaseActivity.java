package com.flamezz.myshoppingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PurchaseActivity extends AppCompatActivity {
    private Button buttonBuyNow,buttonExploreMore;
    private String name,price;
    private int image;
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_purchase);
        Initialize();
        settingUpOrders();
    }

    public void Initialize()
    {
        name = getIntent().getStringExtra("NAME");
         price = getIntent().getStringExtra("PRICE");
         image = getIntent().getIntExtra("IMAGE",0);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        ImageView imageView = findViewById(R.id.productImage);
        textViewName.setText(name);
        textViewPrice.setText(price);
        imageView.setImageResource(image);
        buttonExploreMore = findViewById(R.id.buttonExploreMore);
        buttonExploreMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
        buttonBuyNow = findViewById(R.id.buttonBuyNow);
        buttonBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Purchase Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void settingUpOrders()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREF",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("price",price);
        editor.putInt("image",image);
        editor.commit();
    }
}
