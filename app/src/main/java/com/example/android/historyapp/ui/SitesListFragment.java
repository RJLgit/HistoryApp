package com.example.android.historyapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.historyapp.R;
import com.example.android.historyapp.data.Castles;
import com.example.android.historyapp.data.DummyData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SitesListFragment extends Fragment {
    public static ArrayList<String> dummyData = new ArrayList<>();
    public static ArrayList<Castles> dummyD;
    public SitesListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sites_list, container, false);
        dummyD = new ArrayList<>();
        dummyD = DummyData.generateAndReturnData(getContext());

        dummyData.clear();
        dummyData.add("Castle 1");
        dummyData.add("Castle 2");
        dummyData.add("Castle 3");
        dummyData.add("Castle 4");
        dummyData.add("Castle 5");
        dummyData.add("Castle 6");
        dummyData.add("Castle 7");
        dummyData.add("Castle 8");
        dummyData.add("Castle 9");
        dummyData.add("Castle 10");
        dummyData.add("Castle 11");
        dummyData.add("Castle 12");
        dummyData.add("Castle 13");
        dummyData.add("Castle 14");
        dummyData.add("Castle 15");
        RecyclerView recyclerView = rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        SitesAdapter mAdapter = new SitesAdapter(getActivity(), dummyD, (SitesAdapter.OnRecyclerItemClickListener) getActivity());
        recyclerView.setAdapter(mAdapter);
        return rootView;
    }


}
