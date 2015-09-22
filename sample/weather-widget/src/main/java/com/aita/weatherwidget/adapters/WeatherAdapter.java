package com.aita.weatherwidget.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aita.weatherwidget.fragments.WeatherFragment;
import com.aita.weatherwidget.other.AirportWeather;

import java.util.List;

public class WeatherAdapter extends FragmentStatePagerAdapter {

    private final List<AirportWeather> mAirports;

    public WeatherAdapter(final FragmentManager fm, final List<AirportWeather> airports) {
        super(fm);
        mAirports = airports;
    }

    @Override
    public Fragment getItem(int position) {
        final AirportWeather airport = mAirports.get(position);
        return WeatherFragment.newInstance(airport.imageId, airport.temperature, airport.place);
    }

    @Override
    public int getCount() {
        return mAirports.size();
    }
}
