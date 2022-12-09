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

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class HomeAd extends RecyclerView.Adapter<HomeAd.MyViewHolder> {

    Context context;
    JSONArray jsonArray;

    public HomeAd(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_single_homead, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            holder.iv_ads.setImageDrawable(context.getDrawable(jsonArray.getInt(position)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_ads;
        TextView tv_ad;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_ads = itemView.findViewById(R.id.iv_ads);
            tv_ad = itemView.findViewById(R.id.tv_ad);
        }
    }
}
