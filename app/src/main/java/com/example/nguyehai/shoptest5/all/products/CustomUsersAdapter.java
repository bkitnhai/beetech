package com.example.nguyehai.shoptest5.all.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nguyehai.shoptest5.R;
import com.example.nguyehai.shoptest5.datas.DataPhone;

import java.util.ArrayList;

public class CustomUsersAdapter extends ArrayAdapter<DataPhone> {
    public CustomUsersAdapter(Context context, ArrayList<DataPhone> dataForiPhones) {
        super(context, 0, dataForiPhones);
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataPhone dataForiPhone = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_iphone, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHometown);
        // Populate the data into the template view using the data object
        tvName.setText(dataForiPhone.name);
        //tvHome.setText(dataForiPhone.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
