package com.example.weather_app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherAndForecastFragment extends Fragment {

    private WeatherFragment weatherFragment;
    private ForecastFragment forecastFragment;

    public WeatherAndForecastFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);


        weatherFragment = new WeatherFragment();
        forecastFragment = new ForecastFragment();


        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.weather_fragment_container, weatherFragment);
        fragmentTransaction.add(R.id.forecast_fragment_container, forecastFragment);

        fragmentTransaction.commit();

        return view;
    }
}