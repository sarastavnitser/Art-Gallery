package com.example.artgallery;
//package com.example.digitalartgallery;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.ArrayList;
//
//// Extends the Adapter class to RecyclerView.Adapter
//// and implement the unimplemented methods
//public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//    int[] images;
//    Context context;
//    String[] imageNames;
//
//    // Constructor for initialization
//    public Adapter(Context context, int[] images, String[] imageNames) {
//        this.context = context;
//        this.images = images;
//        this.imageNames  = imageNames;
//    }
//
//    @NonNull
//    @Override
//    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//
//        // Passing view to ViewHolder
//        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
//        return viewHolder;
//    }
//
//    // Binding data to the into specified position
//    @Override
//    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
//        // TypeCast Object to int type
////        int res = (int) images.get(position);
//        holder.images.setImageResource(images[position]);
//    }
//
//    @Override
//    public int getItemCount() {
//        // Returns number of items currently available in Adapter
//        return images.size();
//    }
//
//    // Initializing the Views
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView images;
//
//        public ViewHolder(View view) {
//            super(view);
//            images = (ImageView) view.findViewById(R.id.imageView);
//        }
//    }
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Extends the Adapter class to RecyclerView.Adapter
// and implement the unimplemented methods
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList images;
    Context context;

    // Constructor for initialization
    public Adapter(Context context, ArrayList images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        // Passing view to ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binding data to the into specified position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TypeCast Object to int type
        int res = (int) images.get(position);
        holder.images.setImageResource(res);
    }

    @Override
    public int getItemCount() {
        // Returns number of items currently available in Adapter
        return images.size();
    }

    // Initializing the Views
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;

        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}