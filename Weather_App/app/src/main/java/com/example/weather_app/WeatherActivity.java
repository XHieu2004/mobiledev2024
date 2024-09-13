package com.example.weather_app;

import android.os.Bundle;


import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class WeatherActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private WeatherAndForecastPagerAdapter adapter;

    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        viewPager2 = findViewById(R.id.weather_viewpager);
        adapter = new WeatherAndForecastPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        Log.d("WeatherActivity", "ViewPager2 adapter set");

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