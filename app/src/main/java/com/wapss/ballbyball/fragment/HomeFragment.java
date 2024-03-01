package com.wapss.ballbyball.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.wapss.ballbyball.MyPagerAdapter;
import com.wapss.ballbyball.R;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home = inflater.inflate(R.layout.fragment_home, container, false);
        // assign variable
        tabLayout=home.findViewById(R.id.tabLayout);
        viewPager=home.findViewById(R.id.view_pager);

        // Set up the ViewPager with the sections adapter
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(requireActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);


        return home;
    }
}