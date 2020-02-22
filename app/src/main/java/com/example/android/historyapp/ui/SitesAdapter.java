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
    private OnRecyclerItemClickListener mListener;

    public SitesAdapter(Context context, ArrayList<String> siteNames, OnRecyclerItemClickListener listener) {
        mContext = context;
        mData = siteNames;
        mListener = listener;
    }

    @NonNull
    @Override
    public SitesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new SitesViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SitesViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SitesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;
        OnRecyclerItemClickListener onRecyclerItemClickListener;
        public SitesViewHolder(@NonNull View itemView, OnRecyclerItemClickListener myListen) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.recycler_text_view);
            onRecyclerItemClickListener = myListen;
            itemView.setOnClickListener(this);
        }

        void bind(String castle) {
            mTextView.setText(castle);
        }

        @Override
        public void onClick(View view) {
            onRecyclerItemClickListener.onMyItemClicked(getAdapterPosition());
        }
    }

    public interface OnRecyclerItemClickListener{
        void onMyItemClicked(int i);
    }
}
