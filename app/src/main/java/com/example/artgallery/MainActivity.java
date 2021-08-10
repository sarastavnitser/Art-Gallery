package com.example.artgallery;
//package com.example.digitalartgallery;
//
//import android.content.Context;
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.StaggeredGridLayoutManager;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class MainActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//
//    // Using ArrayList to store images data
//    private int[] images = {R.drawable.img1,R.drawable.img2, R.drawable.img3, R.drawable.img4};
////    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.img1,R.drawable.img2, R.drawable.img3, R.drawable.img4 ));
//
//private String[] imageNames = {"Image 1", "Image 2", "image 3 ", "Image 4"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Getting reference of recyclerView
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//
//        // Setting the layout as Staggered Grid for vertical orientation
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//
//        // Sending reference and data to Adapter
//        Adapter adapter = new Adapter(this, images, imageNames);
//
//        // Setting Adapter to RecyclerView
//        recyclerView.setAdapter(adapter);
//    }
//}

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private  final int COLUMNS_SMALL = 4;
    private  final int COLUMNS_MEDIUM = 2;
    private  final int COLUMNS_LARGE = 1;

    Snackbar mSnackBar;
    RecyclerView recyclerView;
    int columnCount;

    // Using ArrayList to store images data
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        columnCount = COLUMNS_SMALL;
                // Setting the layout as Staggered Grid for vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(columnCount, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        // Sending reference and data to Adapter
        com.example.artgallery.Adapter adapter = new com.example.artgallery.Adapter(MainActivity.this, images);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        setupToolbar();



    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about_the_artist: {
                aboutTheArtist();
                return true;
            }
            case R.id.action_display_settings: {
                DisplaySettings();
                return true;
            }
            case R.id.action_filters: {
                filters();
                return true;
            }
            case R.id.action_search: {
                search();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
}

    private void search() {
    }


    private void filters() {
    }


    private void DisplaySettings() {
        Intent intent = new Intent(getApplicationContext(), DisplaySettings.class);
        startActivityForResult(intent,1);
    }



    private void aboutTheArtist() {



        Intent intent = new Intent(getApplicationContext(), com.example.artgallery.AboutActivity.class);
        startActivity(intent);
    }
    }

