package com.example.nguyehai.shoptest5.all.products;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nguyehai.shoptest5.R;
import com.example.nguyehai.shoptest5.database.JSONParser;
import com.example.nguyehai.shoptest5.datas.DataPhone;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static android.R.attr.value;

public class All_Products extends AppCompatActivity {
    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();
    // products JSONArray
    JSONArray products = null;
    JSONArray json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        // Loading products in Background Thread
        new LoadAllProducts().execute();
    }

    private void populateUsersList() {
        // Construct the data source
        ArrayList<DataPhone> arrayOfDataForiPhones =  new ArrayList<DataPhone>(); //DataPhone.getUsers();
        for (int i = 0; i < json.length(); i++) {
            try {
                arrayOfDataForiPhones.add(new DataPhone(json.getJSONObject(i).getString("Name")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        // Create the adapter to convert the array to views
        CustomAdapteriPhone adapter = new CustomAdapteriPhone(this, arrayOfDataForiPhones);
        // Attach the adapter to a ListView
        final ListView listView = (ListView) findViewById(R.id.lvUsers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {

                String value2= null;
                try {
                    value2 = json.getJSONObject(position).getString("Name");
               } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent myIntent = new Intent(All_Products.this, All_Products_Phone7.class);
                myIntent.putExtra("Name", value2); //Optional parameters
                All_Products.this.startActivity(myIntent);
            }
        });
    }

    class LoadAllProducts extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            json = jParser.makeHttpRequest("http://www.oslophone.com/server/CategoryParse.php", "GET", params);
            try {
                _("test"+json.getJSONObject(0).getString("Name"));
                _("test"+json.getJSONObject(1));

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {


            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
					/*
					  Updat`ing parsed JSON data into ListView
					 */
                    populateUsersList();
                }
            });

        }

    }

    public void _(String s){
        Log.i("app", "Custom" + "##########" + s);
    }



}
