package com.aita.widgettemplate;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceIdentifier());
        loadComponents();
        loadInfoView();
        initializeToolBar();
    }

    private void loadComponents() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void loadInfoView() {
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
        }
    }

    protected void initializeToolBar() {
        if (mToolBar != null) {
            setTitle(getTitleToolBar());
            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(getDisplayHomeAsUp());
                actionBar.setHomeButtonEnabled(getHomeButtonEnabled());
            }
        }
    }

    protected abstract int getLayoutResourceIdentifier();

    protected abstract String getTitleToolBar();

    protected abstract boolean getDisplayHomeAsUp();

    protected abstract boolean getHomeButtonEnabled();

}
