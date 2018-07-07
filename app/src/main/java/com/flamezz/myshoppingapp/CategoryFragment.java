package com.flamezz.myshoppingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }

    String[] title = {"Mobile,Computers","TV,Appliances,Electronics","Men's Fashion","Women's Fashion","Home,Kitchen,Pets","Beauty,Health,Grocery",
            "Sports,Fitness,Bags,Luggage","Books","Toys,Baby Products","Mobile Recharges","Gift Cards","Global Store"};
    int[] images = {R.drawable.computer,R.drawable.tv,R.drawable.shirt,R.drawable.dress,R.drawable.home,R.drawable.local_grocery,
            R.drawable.fitness,R.drawable.book,R.drawable.toys,R.drawable.mobile,R.drawable.giftcard,R.drawable.store};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ListView listView = view.findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        return view;
    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_view,null);
            TextView listViewTitle;
            ImageView imageView;
            listViewTitle = view.findViewById(R.id.listViewTitle);
            imageView = view.findViewById(R.id.listViewImage);
            listViewTitle.setText(title[i]);
            imageView.setImageResource(images[i]);
            return view;
        }
    }

}
