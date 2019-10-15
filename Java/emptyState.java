package com.example.nitishkumar.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class emptyState extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_state);
        TextView empty = (TextView) findViewById(R.id.empty_view);
        empty.setText("Application needs to connect to the internet to initialize for the first time");
    }
}
