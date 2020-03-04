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
        Bundle arguments = new Bundle();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_ID)) {
            String title = intent.getStringExtra(SitesDetailsFragment.ARG_ITEM_ID);

            arguments.putString(SitesDetailsFragment.ARG_ITEM_ID, title);

        }
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_HISTORY)) {
                String history = intent.getStringExtra(SitesDetailsFragment.ARG_ITEM_HISTORY);

                arguments.putString(SitesDetailsFragment.ARG_ITEM_HISTORY, history);
            }
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_AUDIO)) {

            }
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_RATING)) {
                int rating = intent.getIntExtra(SitesDetailsFragment.ARG_ITEM_RATING, 0);
                arguments.putInt(SitesDetailsFragment.ARG_ITEM_RATING, rating);
            }
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_OPERATOR)) {
                String operator = intent.getStringExtra(SitesDetailsFragment.ARG_ITEM_OPERATOR);

                arguments.putString(SitesDetailsFragment.ARG_ITEM_OPERATOR, operator);
            }
            if (intent.hasExtra(SitesDetailsFragment.ARG_ITEM_IMAGE)) {

            }
        SitesDetailsFragment fragment = new SitesDetailsFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment, fragment).commit();
        }

    }
}
