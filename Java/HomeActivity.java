package com.example.nitishkumar.currencyconverter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntemt = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(homeIntemt);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
