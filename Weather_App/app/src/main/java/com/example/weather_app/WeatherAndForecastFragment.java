package com.example.weather_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class WeatherAndForecastFragment extends Fragment {

    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        transaction.replace(R.id.weather_fragment_container, new WeatherFragment());


        transaction.replace(R.id.forecast_fragment_container, new ForecastFragment());

        transaction.commit();
        Log.d("WeatherAndForecastFragment", "Fragments added");

        return view;
    }
}

