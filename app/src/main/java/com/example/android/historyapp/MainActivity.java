package com.example.android.historyapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mFindSitesNearMeButton;
    Button mSeeAllSitesButton;
    Button mSeeSitesOnMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindSitesNearMeButton = findViewById(R.id.findSitesNearMeButton);
        mSeeAllSitesButton = findViewById(R.id.seeAllSitesButton);
        mSeeSitesOnMapButton = findViewById(R.id.findSitesNearMeButton);
    }
}
