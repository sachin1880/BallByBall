package com.wapss.ballbyball.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.wapss.ballbyball.MyPagerAdapter;
import com.wapss.ballbyball.R;

public class MatcheFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View match = inflater.inflate(R.layout.fragment_matche, container, false);
        tabLayout=match.findViewById(R.id.tabLayout);
        viewPager=match.findViewById(R.id.viewPager1);

        // Set up the ViewPager with the sections adapter
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(requireActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);


        return match;
    }
}