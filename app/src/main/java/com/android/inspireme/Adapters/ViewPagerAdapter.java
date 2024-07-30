package com.android.inspireme.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.inspireme.screens.ChanakyaFragment;
import com.android.inspireme.screens.GeetaFragment;
import com.android.inspireme.screens.VidurFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GeetaFragment();
        } else if (position == 1) {
            return new ChanakyaFragment();
        } else { // position == 2
            return new VidurFragment();
        }
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Bhagwat Geeta";
        } else if (position == 1) {
            return "Chanakya Quotes";
        } else { // position == 2
            return "Vidur Quotes";
        }
    }

    @Override
    public int getCount() {
        return 3; // no. of Tabs
    }
}
