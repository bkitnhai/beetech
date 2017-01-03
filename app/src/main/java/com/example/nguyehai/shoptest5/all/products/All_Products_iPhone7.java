package com.example.nguyehai.shoptest5.all.products;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nguyehai.shoptest5.R;
import com.example.nguyehai.shoptest5.database.JSONParser;
import com.example.nguyehai.shoptest5.datas.DataPhone;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class All_Products_iPhone7 extends AppCompatActivity {
    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();
    JSONArray json;
    String value_from_All_Products = null;

    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        Intent intent = getIntent();
        value_from_All_Products = intent.getStringExtra("Name"); //if it's a string you stored.
        // Loading products in Background Thread
        new LoadAllProducts().execute();
    }
    class LoadAllProducts extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(All_Products_iPhone7.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

        }

        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Name",value_from_All_Products));
            // getting JSON string from URL
            json = jParser.makeHttpRequest("http://www.oslophone.com/server/BranchProducts.php", "GET", params);
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {

            pDialog.dismiss();
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
    private void populateUsersList() {
        // Construct the data source
        ArrayList<DataPhone> arrayOfDataForiPhones =  new ArrayList<DataPhone>(); //DataPhone.getUsers();
        for (int i = 0; i < json.length(); i++) {
            try {
                arrayOfDataForiPhones.add(new DataPhone(json.getJSONObject(i).getString("Model")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        // Create the adapter to convert the array to views
        _("arrayOfDataForiPhones"+arrayOfDataForiPhones);
        CustomAdapteriPhone adapter = new CustomAdapteriPhone(this, arrayOfDataForiPhones);
        _("adapter"+adapter);
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
                    value2 = json.getJSONObject(position).getString("Model");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                _(value2);
                Intent myIntent = new Intent(All_Products_iPhone7.this, All_Products_iPhone7_Detail.class);
                myIntent.putExtra("Model", value2); //Optional parameters
                All_Products_iPhone7.this.startActivity(myIntent);
            }
        });
    }

    public void _(String s){
        Log.i("app", "Custom" + "##########" + s);
    }

}
