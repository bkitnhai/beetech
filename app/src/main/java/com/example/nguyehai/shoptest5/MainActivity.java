package com.example.nguyehai.shoptest5;

        import android.app.TabActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TabHost;

public class MainActivity extends TabActivity {

    // test 2
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        // Tab for Photos
        TabHost.TabSpec Recents = tabHost.newTabSpec("Recents");
        // setting Title and Icon for the Tab
        Recents.setIndicator("Recents", getResources().getDrawable(R.drawable.testicon));
        Intent RecentsIntent = new Intent(this, Recents.class);
        Recents.setContent(RecentsIntent);

        // Tab for Songs
        TabHost.TabSpec All_Products = tabHost.newTabSpec("All Products");
        All_Products.setIndicator("All Products", getResources().getDrawable(R.drawable.testicon));
        Intent All_ProductsIntent = new Intent(this, All_Products.class);
        All_Products.setContent(All_ProductsIntent);

        // Tab for Videos
        TabHost.TabSpec Carts = tabHost.newTabSpec("Carts");
        Carts.setIndicator("Carts", getResources().getDrawable(R.drawable.testicon));
        Intent CartssIntent = new Intent(this, Carts.class);
        Carts.setContent(CartssIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(Recents); // Adding photos tab
        tabHost.addTab(All_Products); // Adding songs tab
        tabHost.addTab(Carts); // Adding videos tab
    }
}
