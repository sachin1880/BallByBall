package com.wapss.ballbyball;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wapss.ballbyball.fragment.AllFragment;
import com.wapss.ballbyball.fragment.LiveFragment;
import com.wapss.ballbyball.fragment.UpcomingFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    // Initialize arrayList
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllFragment();
            case 1:
                return new LiveFragment();
            case 2:
                return new UpcomingFragment();
            default:
              //  Log.d("tag","Null");
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Number of tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Set tab titles (optional)
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Live";
            case 2:
                return "Upcoming";
            default:
                return null;
        }
    }
}
