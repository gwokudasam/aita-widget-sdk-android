package com.aita.weatherwidget.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aita.weatherwidget.fragments.ErrorFragment;

public class ErrorAdapter extends FragmentStatePagerAdapter {

    public ErrorAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ErrorFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
