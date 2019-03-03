package com.ckdtech.www.irproject;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent a = new Intent(SplashActivity.this,IndexActivity.class);
                startActivity(a);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}