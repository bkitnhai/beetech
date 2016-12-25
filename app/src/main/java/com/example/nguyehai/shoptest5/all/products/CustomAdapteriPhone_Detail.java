package com.example.nguyehai.shoptest5.all.products;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.nguyehai.shoptest5.R;
import com.example.nguyehai.shoptest5.all.products.backEndOfAllPhones.AppController;
import com.example.nguyehai.shoptest5.datas.DataPhone;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapteriPhone_Detail extends BaseAdapter {

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataPhone> phoneCell;
    public CustomAdapteriPhone_Detail(Activity activity, List<DataPhone> dataForiPhones) {
            this.activity = activity;
        this.phoneCell = dataForiPhones;
   }

    @Override
    public int getCount() {
        return phoneCell.size();
    }

    @Override
    public Object getItem(int position) {
        return phoneCell.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
     public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell_custom_list_iphone7_detail, parent, false);
        }
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.ivUserIcon);
        // getting movie data for the row
        DataPhone m = phoneCell.get(position);

        TextView size = (TextView) convertView.findViewById(R.id.size);
         TextView color = (TextView) convertView.findViewById(R.id.color);
         TextView condition = (TextView) convertView.findViewById(R.id.condition);
         TextView description = (TextView) convertView.findViewById(R.id.description);
         TextView model = (TextView) convertView.findViewById(R.id.model);
        size.setText(m.name);
         color.setText(m.color);
         condition.setText(m.condition);
         size.setText(m.size);
         description.setText(m.description);
         model.setText(m.model);

         thumbNail.setImageUrl(m.imagelink, imageLoader);

         //tvHome.setText(dataForiPhone.hometown);
        // Return the completed view to render on screen
        return convertView;
    }

    public void _(String s){
        Log.i("app", "Custom" + "##########" + s);
    }

}
