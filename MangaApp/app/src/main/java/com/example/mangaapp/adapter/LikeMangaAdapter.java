package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemHotMangaBinding;
import com.example.mangaapp.databinding.ItemLikeMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class LikeMangaAdapter extends RecyclerView.Adapter<LikeMangaAdapter.ViewHolder> {
    private ArrayList<Manga> arrayListLikeManga = new ArrayList<>();
    private Context context;

    public LikeMangaAdapter(Context context) {
        this.context = context;
    }

    public void setArrayListLikeManga(ArrayList<Manga> arrayListLikeManga) {
        this.arrayListLikeManga = arrayListLikeManga;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLikeMangaBinding itemLikeMangaBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_like_manga,parent,false);
        return new ViewHolder(itemLikeMangaBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemLikeMangaBinding.textViewLikeManga.setText(arrayListLikeManga.get(position).name_manga);
        Glide.with(context).load(arrayListLikeManga.get(position).avatar).into(holder.itemLikeMangaBinding.imageLikeManga);
    }

    @Override
    public int getItemCount() {
        if (arrayListLikeManga == null) return 0;
        return arrayListLikeManga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLikeMangaBinding itemLikeMangaBinding;

        public ViewHolder(@NonNull ItemLikeMangaBinding itemLikeMangaBinding) {
            super(itemLikeMangaBinding.getRoot());
            this.itemLikeMangaBinding = itemLikeMangaBinding;

        }
    }
}
