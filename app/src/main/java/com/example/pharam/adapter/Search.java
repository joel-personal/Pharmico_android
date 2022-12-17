package com.example.pharam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharam.R;


public class Search extends RecyclerView.Adapter<Search.MyViewHolder> {

    Context context;

    public Search(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_single_search, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
