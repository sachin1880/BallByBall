package com.wapss.ballbyball.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wapss.ballbyball.R;
import com.wapss.ballbyball.activity.FaqActivity;
import com.wapss.ballbyball.activity.LoginActivity;
import com.wapss.ballbyball.activity.ProfileActivity;

public class Profile_Fragment extends Fragment {
    LinearLayout btn_profile,ll_logOut,help,ll_rating;
    private Dialog noInternetDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profile = inflater.inflate(R.layout.fragment_profile_, container, false);
        btn_profile = profile.findViewById(R.id.btn_profile);
        ll_logOut = profile.findViewById(R.id.ll_logOut);
        help = profile.findViewById(R.id.help);
        ll_rating = profile.findViewById(R.id.ll_rating);

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        ll_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpLogOut();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FaqActivity.class);
                startActivity(intent);
            }
        });
        ll_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingPopUp();
            }
        });

        return profile;
    }

    private void ratingPopUp() {
        noInternetDialog = new Dialog(getContext());
        noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        noInternetDialog.setContentView(R.layout.rating_layout);
        noInternetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        noInternetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        noInternetDialog.show();
        TextView et_yes = (TextView)noInternetDialog.findViewById(R.id.et_yes);
        TextView et_cancel = (TextView)noInternetDialog.findViewById(R.id.et_cancel);
        ImageView iv_cancel = (ImageView)noInternetDialog.findViewById(R.id.iv_cancel);
        et_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences preferences = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.clear();
//                editor.apply();
//                Intent intent = new Intent(getContext(), LoginActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
                noInternetDialog.dismiss();
            }
        });
        iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noInternetDialog.dismiss();
            }
        });
        noInternetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        noInternetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private void PopUpLogOut() {
        noInternetDialog = new Dialog(getContext());
        noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        noInternetDialog.setContentView(R.layout.logout_layout);
        noInternetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        noInternetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        noInternetDialog.show();
        TextView et_yes = (TextView)noInternetDialog.findViewById(R.id.et_yes);
        TextView et_cancel = (TextView)noInternetDialog.findViewById(R.id.et_cancel);
        et_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences preferences = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.clear();
//                editor.apply();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        et_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noInternetDialog.dismiss();
            }
        });
        noInternetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        noInternetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}