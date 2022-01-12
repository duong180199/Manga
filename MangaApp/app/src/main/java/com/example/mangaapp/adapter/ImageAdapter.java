package com.example.mangaapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemImageBinding;
import com.example.mangaapp.model.Chapter;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> images;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.images = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding itemImageBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_image,parent,false);
        return new ViewHolder(itemImageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Glide.with(context).load(images.get(position)).into(holder.itemImageBinding.imageChapter);
    }

    @Override
    public int getItemCount() {
        return images != null ? images.size() : 0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ItemImageBinding itemImageBinding;
        public ViewHolder(@NonNull ItemImageBinding itemImageBinding) {
            super(itemImageBinding.getRoot());
            this.itemImageBinding = itemImageBinding;
        }
    }
}
