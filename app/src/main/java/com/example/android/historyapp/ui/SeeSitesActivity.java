package com.example.android.historyapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.historyapp.R;

public class SeeSitesActivity extends AppCompatActivity implements SitesAdapter.OnRecyclerItemClickListener {
    private boolean isTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_sites);




        if (findViewById(R.id.divider_view) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
        if (isTwoPane) {
            SeeMoreInfoFragment seeMoreInfoFragment = new SeeMoreInfoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment, seeMoreInfoFragment).commit();
        }

    }

    @Override
    public void onMyItemClicked(int i) {
        if (!isTwoPane) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(SitesDetailsFragment.ARG_ITEM_ID, SitesListFragment.dummyD.get(i).getName());
            intent.putExtra(SitesDetailsFragment.ARG_ITEM_HISTORY, SitesListFragment.dummyD.get(i).getHistory());
            intent.putExtra(SitesDetailsFragment.ARG_ITEM_OPERATOR, SitesListFragment.dummyD.get(i).getOperator());
            intent.putExtra(SitesDetailsFragment.ARG_ITEM_RATING, SitesListFragment.dummyD.get(i).getRating());
            startActivity(intent);

        } else {
            //Pass data about item clicked from here
            Bundle arguments = new Bundle();
            arguments.putString(SitesDetailsFragment.ARG_ITEM_ID, SitesListFragment.dummyD.get(i).getName());
            arguments.putString(SitesDetailsFragment.ARG_ITEM_HISTORY, SitesListFragment.dummyD.get(i).getHistory());
            arguments.putString(SitesDetailsFragment.ARG_ITEM_OPERATOR, SitesListFragment.dummyD.get(i).getOperator());
            arguments.putDouble(SitesDetailsFragment.ARG_ITEM_RATING, SitesListFragment.dummyD.get(i).getRating());
            SitesDetailsFragment fragment = new SitesDetailsFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction().replace(R.id.details_fragment, fragment).commit();

        }
    }
}
