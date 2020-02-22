package com.example.android.historyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.historyapp.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(SitesDetailsFragment.ARG_ITEM_ID)) {
            String title = intent.getStringExtra(SitesDetailsFragment.ARG_ITEM_ID);
            Bundle arguments = new Bundle();
            arguments.putString(SitesDetailsFragment.ARG_ITEM_ID, title);
            SitesDetailsFragment fragment = new SitesDetailsFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment, fragment).commit();
        }
    }
}
