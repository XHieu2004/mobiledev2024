package com.example.weather_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WeatherAndForecastPagerAdapter extends FragmentStateAdapter {
    public WeatherAndForecastPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);

    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new WeatherAndForecastFragment();
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
