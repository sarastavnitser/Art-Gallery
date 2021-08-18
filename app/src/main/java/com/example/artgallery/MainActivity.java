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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity {

    StaggeredGridLayoutManager staggeredGridLayoutManager;
    private String[] columnsArray;

    Snackbar mSnackBar;
    RecyclerView recyclerView;
    int columnCount;

    // Using ArrayList to store images data
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.all_dressed_up, R.drawable.alpine_edelweis,
            R.drawable.be_strong_and_enduring_like_me, R.drawable.beauty_in_bloom, R.drawable.best_blossoms,
            R.drawable.chasing_beauty, R.drawable.delicate_beauty, R.drawable.elegance_and_daintiness,
            R.drawable.euphoria_scaled, R.drawable.favorite_succulents, R.drawable.floating_star,
            R.drawable.flower_of_my_sweet_dream, R.drawable.flying_stars, R.drawable.red_treasure_on_gold,
            R.drawable.star_is_born, R.drawable.summmer_afternoon, R.drawable.tenderness, R.drawable.the_hibiscus_with_rhythm,
            R.drawable.whiff_of_forgotten_love));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        columnsArray = getResources().getStringArray(R.array.size_values);

        columnCount = Integer.parseInt(columnsArray[1]);
        // Setting the layout as Staggered Grid for vertical orientation


        staggeredGridLayoutManager = new StaggeredGridLayoutManager(columnCount,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        // Sending reference and data to Adapter
        com.example.artgallery.Adapter adapter = new com.example.artgallery.Adapter(MainActivity.this, images);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        setupToolbar();


    }

    @Override
    protected void onStart() {
        super.onStart();

        readColumnCountFromPreferences();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        if (requestCode == 1) {
            readColumnCountFromPreferences();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void readColumnCountFromPreferences() {
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences(this);
        String strCount = defaultSharedPreferences.getString("column_number", columnsArray[1]);
        strCount = strCount.equals("") ? columnsArray[1] : strCount;
        columnCount = Integer.parseInt(strCount);
        staggeredGridLayoutManager.setSpanCount(columnCount);
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
                SettingsActivity();
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


    private void SettingsActivity() {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivityForResult(intent, 1);
    }


    private void aboutTheArtist() {


        Intent intent = new Intent(getApplicationContext(), com.example.artgallery.AboutActivity.class);
        startActivity(intent);
    }
}

