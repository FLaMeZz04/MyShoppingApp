package com.flamezz.myshoppingapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SectionPageAdapter sectionPageAdapter;
    private ViewPager viewPager;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        sectionPageAdapter = new SectionPageAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

public void setUpViewPager(ViewPager viewPager)
{
    SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getChildFragmentManager());
    sectionPageAdapter.addFragment(new MobileTab(),"Mobile");
    sectionPageAdapter.addFragment(new FashionTab(),"Fashion");
    sectionPageAdapter.addFragment(new GroceryTab(),"Grocery");
    viewPager.setAdapter(sectionPageAdapter);

}

    }


