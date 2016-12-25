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

public class CustomAdapteriPhone_Detail extends ArrayAdapter<DataPhone> {
    public CustomAdapteriPhone_Detail(Context context, ArrayList<DataPhone> dataForiPhones) {
        super(context, 0, dataForiPhones);
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataPhone dataForiPhone = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell_custom_list_iphone7_detail, parent, false);
        }
        // Lookup view for data population
        TextView size = (TextView) convertView.findViewById(R.id.size);
         TextView color = (TextView) convertView.findViewById(R.id.color);
         TextView condition = (TextView) convertView.findViewById(R.id.condition);
         TextView description = (TextView) convertView.findViewById(R.id.description);
         TextView model = (TextView) convertView.findViewById(R.id.model);
        size.setText(dataForiPhone.name);
         color.setText(dataForiPhone.color);
         condition.setText(dataForiPhone.condition);
         size.setText(dataForiPhone.size);
         description.setText(dataForiPhone.description);
         model.setText(dataForiPhone.model);
         //tvHome.setText(dataForiPhone.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
