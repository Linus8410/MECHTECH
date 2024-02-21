package com.example.mechtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    Orderadapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Headlights", getString(R.string.headlights), R.drawable.headlightt));
        modelList.add(new Model("bumper", getString(R.string.bumper), R.drawable.bumper));
        modelList.add(new Model("breaklights", getString(R.string.breaklights), R.drawable.breaklights));
        modelList.add(new Model("wipers", getString(R.string.wipers), R.drawable.wipers));
        modelList.add(new Model("tyre", getString(R.string.tyre), R.drawable.tyres));
        modelList.add(new Model("rims", getString(R.string.rims), R.drawable.rims));
        modelList.add(new Model("plugs", getString(R.string.plugs), R.drawable.plugs));
        modelList.add(new Model("shocks", getString(R.string.shocks), R.drawable.shocks));
        modelList.add(new Model("turbo", getString(R.string.turbo), R.drawable.turbo));
        modelList.add(new Model("sidemirror",getString(R.string.sidemirror),R.drawable.sidemirror));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // adapter
        mAdapter = new Orderadapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }
}