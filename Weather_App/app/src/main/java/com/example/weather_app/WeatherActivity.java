package com.example.weather_app;

import android.os.Bundle;


import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ViewPager2 viewPager2 = findViewById(R.id.weather_viewpager);
        WeatherAndForecastPagerAdapter adapter = new WeatherAndForecastPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_test);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
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
            }
        }).attach();

    }



//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i(TAG, "onStart() called");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i(TAG, "onResume() called");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i(TAG, "onPause() called");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i(TAG, "onStop() called");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i(TAG, "onDestroy() called");
//    }
}