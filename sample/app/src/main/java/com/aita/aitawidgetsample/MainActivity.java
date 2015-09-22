package com.aita.aitawidgetsample;

import android.os.Bundle;
import android.util.Log;

import com.aita.aitawidgetlibrary.analytics.WidgetTracker;
import com.aita.aitawidgetlibrary.model.WidgetAirline;
import com.aita.aitawidgetlibrary.model.WidgetAirport;
import com.aita.aitawidgetlibrary.model.WidgetFlight;
import com.aita.aitawidgetlibrary.view.WidgetView;

public class MainActivity extends BaseActivity implements WidgetTracker {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final WidgetView weatherWidget = (WidgetView) findViewById(R.id.weather_widget);
        weatherWidget.setFlight(getFakeFlight());
        weatherWidget.setTracker(this);
    }

    private WidgetFlight getFakeFlight() {
        final WidgetAirport departureAirport = new WidgetAirport(
                "John F. Kennedy International Airport", // airport name
                "Международный аэропорт им. Дж. Кеннеди", // airport name [RU]
                "New York", // city name
                "Нью-Йорк", // city name [ru]
                "United States", // country name
                "JFK", // IATA code
                "http://www.panynj.gov/airports/jfk.html", // website
                "US", // country code
                "+1 718-244-4444", // phone number
                null, // delay
                182, // tips count
                704, // reports count
                -4.0, // offset from UTC in hours
                40.642333984375, // latitude
                -73.78816986083984, // longitude
                16.31932f, // time spent on checkin
                18.12262f, // time spent on security control
                11.570554f, // time spent on passport control
                3.9f, // rating
                true, // is airport name translated?
                true // is city name translated?
        );

        final WidgetAirport arrivalAirport = new WidgetAirport(
                "Los Angeles International Airport", // airport name
                "Международный аэропорт Лос-Анджелеса", // airport name [RU]
                "Los Angeles", // city name
                "Лос-Анджелес", // city name [ru]
                "United States", // country name
                "LAX", // IATA code
                "http://www.lawa.org/welcomeLAX.aspx", // website
                "US", // country code
                "+1 424-646-5252", // phone number
                null, // delay
                234, // tips count
                305, // reports count
                -7.0, // offset from UTC in hours
                33.943397521972656, // latitude
                -118.40827941894531, // longitude
                18.116615f, // time spent on checkin
                19.718075f, // time spent on security control
                8.542236f, // time spent on passport control
                4.2f, // rating
                true, // is airport name translated?
                true // is city name translated?
        );

        final WidgetAirline airline = new WidgetAirline(
                "AA", // IATA code
                "AA", // ICAO code
                "American Airlines", // airline name
                "Американские Авиалинии", // airline name [ru]
                null, // twitter login
                null, // email
                "+1800-4337300", // phone number
                "http://www.aa.com", // website
                "AA", // code
                null, // online checkin - web version
                "https://www.aa.com/reservation/flightCheckInViewReservationsAccess.do?" +
                        "anchorEvent=false" +
                        "&from=Nav" +
                        "&v_locale=en_US" +
                        "&v_mobileUAFlag=AA" +
                        "&anchorEvent=false" +
                        "&from=Nav", // online checkin - mobile version
                true, // is online checkin available?
                true // is name translated?
        );

        final WidgetFlight flight = new WidgetFlight(
                3973.3806f, // distance
                "Scheduled", // status
                "31B", //seat
                "Economy", //seat zone
                "MKF6HE", // booking reference
                "737", // equipment
                "1", // flight number
                "AA", // airline IATA code
                22200L, // duration in seconds
                1442912400L, // checkin time
                1442916200L, // boarding time
                1442920000L, // take off time
                1442923800L, // landing time
                arrivalAirport, // arrival airport
                departureAirport, // departure airport
                airline // airline
        );

        return flight;
    }

    @Override
    public void sendEvent(String action, String label) {
        // we'll send your event to our tracker here
        Log.d("Analytics", "action: " + action + ", label: " + label);
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean getDisplayHomeAsUp() {
        return false;
    }

    @Override
    protected boolean getHomeButtonEnabled() {
        return false;
    }
}
