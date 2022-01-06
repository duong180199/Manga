package com.example.mangaapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemHotMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;


public class HotMangaAdapter extends RecyclerView.Adapter<HotMangaAdapter.ViewHolder>{
    private ArrayList<Manga> mangaArrayList;
    private Context context;

    public HotMangaAdapter(Context context) {
        this.context = context;
    }

    public void setMangaArrayList(ArrayList<Manga> mangaArrayList) {
        this.mangaArrayList = mangaArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHotMangaBinding itemHotMangaBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_hot_manga,parent,false);
        return new ViewHolder(itemHotMangaBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemHotMangaBinding.textViewHotManga.setText(mangaArrayList.get(position).name_manga);
    }

    @Override
    public int getItemCount() {
        if (mangaArrayList == null) return 0;
        return mangaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemHotMangaBinding itemHotMangaBinding;
        public ViewHolder(@NonNull ItemHotMangaBinding ItemHotMangaBinding) {
            super(ItemHotMangaBinding.getRoot());
            this.itemHotMangaBinding = ItemHotMangaBinding;
        }
    }
}
