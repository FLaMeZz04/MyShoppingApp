package com.flamezz.myshoppingapp;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class ShoppingCartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private OrdersFragment ordersFragment;
    private LogoutFragment logoutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer ,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        settingUpNavigationView();
        InitializeFragment();

    }

public void settingUpNavigationView()
{
    TextView textViewEmail;
    NavigationView navigationView =  findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String email = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail();
    textViewEmail = navigationView.getHeaderView(0).findViewById(R.id.textViewEmail);
    textViewEmail.setText(email);

}



    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shopping_cart, menu);
        return true;
    }

    public void InitializeFragment()
    {
         homeFragment = new HomeFragment();
         ordersFragment = new OrdersFragment();
         categoryFragment = new CategoryFragment();
         logoutFragment = new LogoutFragment();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            setNavigationFragment(homeFragment);
        } else if (id == R.id.nav_category) {
            setNavigationFragment(categoryFragment);

        } else if (id == R.id.nav_orders) {
            setNavigationFragment(ordersFragment);


        } else if(id==R.id.nav_logout)
            setNavigationFragment(logoutFragment);
        {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setNavigationFragment(Fragment fragment)
    {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}
