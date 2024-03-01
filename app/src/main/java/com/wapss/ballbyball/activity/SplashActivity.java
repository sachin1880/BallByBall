package com.wapss.ballbyball.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.wapss.ballbyball.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (token!=null)
//                {
//                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                    finish();
//                }
//                else
//                {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
             //   }
            }
        },3000);

    }
}