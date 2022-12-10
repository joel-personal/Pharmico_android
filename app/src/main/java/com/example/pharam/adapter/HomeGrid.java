package com.example.pharam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharam.R;

public class HomeGrid extends RecyclerView.Adapter<HomeGrid.MyViewHolder> {

    Context context;
    int layout;
    int count;

    public HomeGrid(Context context, int layout, int count) {
        this.context = context;
        this.layout = layout;
        this.count = count;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_medicine;
        TextView tv_medicine;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_medicine = itemView.findViewById(R.id.iv_medicine);
            tv_medicine = itemView.findViewById(R.id.tv_medicine);
        }
    }
}
