package com.example.android.historyapp.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.historyapp.R;

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

        mSeeAllSitesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SeeSitesActivity.class);
                startActivity(intent);
            }
        });
    }
}
