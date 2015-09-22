package com.aita.weatherwidget.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aita.weatherwidget.R;

public class WeatherFragment extends Fragment {

    private static final String ARG_IMG_ID = "img_id";
    private static final String ARG_TEMP = "temp";
    private static final String ARG_PLACE = "place";

    private int mImageId;
    private String mTemperature;
    private String mPlace;

    public static WeatherFragment newInstance(int imageId, String temperature, String place) {
        final WeatherFragment fragment = new WeatherFragment();

        final Bundle args = new Bundle();
        args.putInt(ARG_IMG_ID, imageId);
        args.putString(ARG_TEMP, temperature);
        args.putString(ARG_PLACE, place);
        fragment.setArguments(args);

        return fragment;
    }

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageId = getArguments().getInt(ARG_IMG_ID);
            mTemperature = getArguments().getString(ARG_TEMP);
            mPlace = getArguments().getString(ARG_PLACE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_weather, container, false);

        ((ImageView) rootView.findViewById(R.id.weather_icon)).setImageResource(mImageId);
        ((TextView) rootView.findViewById(R.id.temperature_text)).setText(mTemperature);
        ((TextView) rootView.findViewById(R.id.place_text)).setText(mPlace);

        return rootView;
    }

}
