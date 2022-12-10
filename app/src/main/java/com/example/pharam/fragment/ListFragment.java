package com.example.pharam.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pharam.R;
import com.example.pharam.adapter.HomeGrid;

public class ListFragment extends Fragment {

    RecyclerView rv_medicine1;

    public ListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        rv_medicine1 = view.findViewById(R.id.rv_medicine1);

        populateList();

        return view;
    }

    private void populateList() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rv_medicine1.setLayoutManager(manager);
        HomeGrid grid = new HomeGrid(getContext(), R.layout.row_single_grid, 12);
        rv_medicine1.setAdapter(grid);
    }
}