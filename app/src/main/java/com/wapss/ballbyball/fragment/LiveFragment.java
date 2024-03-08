package com.wapss.ballbyball.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wapss.ballbyball.R;
public class LiveFragment extends Fragment {

    TextView btn_join;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View live = inflater.inflate(R.layout.fragment_main_second, container, false);
        btn_join = live.findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return live;
    }
}