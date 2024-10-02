package com.example.weather_app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;


public class ForecastFragment extends Fragment {
    private ImageView logoImageView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        int color = 0x20FF0000;
        view.setBackgroundColor(color);
        logoImageView = view.findViewById(R.id.logo_image_view);

        return view;

    }
    public void setLogoImage(final InputStream inputStream) {
        if (getActivity() == null) return;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ImageView logoImageView = null;

                logoImageView.setImageBitmap(bitmap);
            }
        });
    }
}