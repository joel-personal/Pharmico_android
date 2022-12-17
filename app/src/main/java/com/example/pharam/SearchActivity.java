package com.example.pharam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pharam.adapter.Search;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class SearchActivity extends AppCompatActivity {

    Spinner sp_arg, sp_type;
    RecyclerView rv_search;
    MaterialButton btn_search;
    TextView tv_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        MaterialToolbar toolbar = findViewById(R.id.tb_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        sp_arg = findViewById(R.id.sp_arg);
        sp_type = findViewById(R.id.sp_type);
        rv_search = findViewById(R.id.rv_search);
        btn_search = findViewById(R.id.btn_search);
        tv_search = findViewById(R.id.tv_search);

        loadSpinnerDataArg();
        loadSpinnerDataType();
        populateSearch();
    }

    private void populateSearch() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv_search.setLayoutManager(manager);
        Search adapter = new Search(this);
        rv_search.setAdapter(adapter);
    }

    private void loadSpinnerDataType() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);
        sp_type.setSelection(0);
    }

    private void loadSpinnerDataArg() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arg, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_arg.setAdapter(adapter);
        sp_arg.setSelection(0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}