package com.example.pharam.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pharam.R;
import com.example.pharam.adapter.HomeAd;
import com.example.pharam.adapter.HomeGrid;

import org.json.JSONArray;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RecyclerView rv_ads, rv_list;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rv_ads = view.findViewById(R.id.rv_ads);
        rv_list = view.findViewById(R.id.rv_list);

        populateAd();
        populateMedicine();
        return view;
    }

    private void populateMedicine() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rv_list.setLayoutManager(manager);
        HomeGrid grid = new HomeGrid(getContext(), R.layout.row_single_homegrid, 6);
        rv_list.setAdapter(grid);
    }

    private void populateAd() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rv_ads.setLayoutManager(manager);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(R.drawable.adv1);
        jsonArray.put(R.drawable.adv2);
        jsonArray.put(R.drawable.adv3);
        HomeAd adapter = new HomeAd(getContext(), jsonArray);
        rv_ads.setAdapter(adapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rv_ads);
    }
}