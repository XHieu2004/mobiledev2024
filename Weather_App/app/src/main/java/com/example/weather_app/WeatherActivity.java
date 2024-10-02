package com.example.weather_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private Toolbar myToolbar;
    private ViewPager2 viewPager2;
    private WeatherAndForecastPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        viewPager2 = findViewById(R.id.weather_viewpager);
        adapter = new WeatherAndForecastPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout_test);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("USTH Weather");

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Ha Noi");
                    break;
                case 1:
                    tab.setText("Paris");
                    break;
                case 2:
                    tab.setText("HCMC");
                    break;
            }
        }).attach();

        myToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.refresh_button) {
                new DownloadLogoTask().execute("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
                return true;
            }
            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private class DownloadLogoTask extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                return connection.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(InputStream result) {
            if (result != null) {
                ForecastFragment fragment = (ForecastFragment) adapter.createFragment(viewPager2.getCurrentItem());
                fragment.setLogoImage(result);
                Toast.makeText(WeatherActivity.this, "Logo downloaded successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(WeatherActivity.this, "Failed to download logo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}