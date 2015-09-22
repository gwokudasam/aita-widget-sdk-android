package com.aita.widgettemplate;

import android.os.Bundle;
import android.util.Log;

import com.aita.aitawidgetlibrary.analytics.WidgetTracker;

public class MainActivity extends BaseActivity implements WidgetTracker {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TODO: set your widget up
//        final WidgetView myAwesomeWidget = (WidgetView) findViewById(R.id.my_awesome_widget);
//        myAwesomeWidget.setFlight(getFakeFlight());
//        myAwesomeWidget.setTracker(this);
    }

    @Override
    public void sendEvent(String action, String label) {
        Log.d("Analytics", "action: " + action + ", label: " + label);
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.widget_sandbox);
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
