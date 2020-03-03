package com.example.android.historyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.historyapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SeeMoreInfoFragment extends Fragment {
    TextView seeMoreInfoTextView;

    public SeeMoreInfoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_click_to_see_details, container, false);
        seeMoreInfoTextView = rootView.findViewById(R.id.seeMoreInfoTextView);
        return rootView;
    }
}
