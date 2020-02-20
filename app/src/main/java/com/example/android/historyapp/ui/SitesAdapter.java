package com.example.android.historyapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.historyapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.SitesViewHolder> {

    private Context mContext;
    private ArrayList<String> mData;

    public SitesAdapter(Context context, ArrayList<String> siteNames) {
        mContext = context;
        mData = siteNames;
    }

    @NonNull
    @Override
    public SitesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new SitesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SitesViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SitesViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public SitesViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.recycler_text_view);
        }

        void bind(String castle) {
            mTextView.setText(castle);
        }

    }
}
