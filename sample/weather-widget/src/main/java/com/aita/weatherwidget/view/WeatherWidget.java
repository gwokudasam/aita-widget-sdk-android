package com.aita.weatherwidget.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.aita.aitawidgetlibrary.model.WidgetAirport;
import com.aita.aitawidgetlibrary.view.WidgetView;
import com.aita.weatherwidget.R;
import com.aita.weatherwidget.adapters.ErrorAdapter;
import com.aita.weatherwidget.adapters.WeatherAdapter;
import com.aita.weatherwidget.other.AirportWeather;
import com.aita.weatherwidget.other.GetTemperatureTask;
import com.aita.weatherwidget.other.LatLng;

import java.util.ArrayList;
import java.util.List;

public class WeatherWidget extends WidgetView implements GetTemperatureTask.TemperatureListener {

    private ViewPager mViewPager;
    private ProgressBar mProgressBar;

    private WidgetAirport mDepartureAirport;
    private WidgetAirport mArrivalAirport;

    public WeatherWidget(Context context) {
        super(context);
    }

    public WeatherWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeatherWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setUpWidget() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mDepartureAirport = mFlight.getDepartureAirport();
        mArrivalAirport = mFlight.getArrivalAirport();

        if (mDepartureAirport != null && mArrivalAirport != null) {
            final LatLng departureAirportLatLng = new LatLng(
                    mDepartureAirport.getLatitude(),
                    mDepartureAirport.getLongitude());

            final LatLng arrivalAirportLatLng = new LatLng(
                    mArrivalAirport.getLatitude(),
                    mArrivalAirport.getLongitude());

            final GetTemperatureTask temperatureTask = new GetTemperatureTask(this);
            temperatureTask.execute(
                    departureAirportLatLng,
                    arrivalAirportLatLng);
        } else {
            mProgressBar.setVisibility(GONE);
            showErrorFragment();
        }
    }

    @Override
    public void onTemperatureLoaded(@NonNull List<Integer> result) {
        mProgressBar.setVisibility(GONE);
        if (result.isEmpty() || result.size() < 2) {
            showErrorFragment();
        } else {
            final ArrayList<AirportWeather> airports = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                final int temp = result.get(i);

                final int imageId;
                if (temp <= 5)
                    imageId = R.drawable.ic_snowflake;
                else if (temp <= 20)
                    imageId = R.drawable.ic_cloud;
                else
                    imageId = R.drawable.ic_sun;

                final String tempStr = temp <= 0 ? String.valueOf(temp) : "+" + temp;
                final String place = i == 0 ?
                        mDepartureAirport.getCode() : mArrivalAirport.getCode();

                airports.add(new AirportWeather(imageId, tempStr, place));
            }

            mViewPager.setAdapter(new WeatherAdapter(getFragmentManager(), airports));
        }
    }

    private void showErrorFragment() {
        mViewPager.setAdapter(new ErrorAdapter(getFragmentManager()));
    }

    private FragmentManager getFragmentManager() {
        try {
            final FragmentActivity activity = (FragmentActivity) mContext;
            return activity.getSupportFragmentManager();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update() {
    }

    @NonNull
    @Override
    protected String getWidgetTitleText() {
        return mContext.getString(R.string.widget_title);
    }

    @NonNull
    @Override
    protected String getWidgetSubtitleText() {
        return mContext.getString(R.string.widget_subtitle);
    }

    @Override
    protected int getWidgetIconId() {
        return R.drawable.ic_widget_icon;
    }

    @Override
    protected int getWidgetViewId() {
        return R.layout.view_widget;
    }
}
