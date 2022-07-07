package com.shubham.solvative;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.shubham.solvative.adapter.RecyclerViewAdapter;
import com.shubham.solvative.data.AllArtwork;
import com.shubham.solvative.data.AsyncResponse;
import com.shubham.solvative.model.Artwork;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Artwork> artworkList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);



        artworkList = new AllArtwork().getAllArtworks(new AsyncResponse() {
            @Override
            public void processFinished(ArrayList<Artwork> artworkArrayList) {
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, artworkArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

                Log.d("MainActivity", "processFinished:  response Size: " + artworkArrayList.size());
            }
        });
//        Log.d("MainActivity", "processFinished:  response Size: " + artworkList.size());


    }
}