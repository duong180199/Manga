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
import com.example.mangaapp.databinding.ItemCategoryMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class CategoryMangaAdapter extends RecyclerView.Adapter<CategoryMangaAdapter.ViewHolder> {
    private ArrayList<Manga> arrayList;
    private Context context;

    public CategoryMangaAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Manga> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryMangaBinding itemCategoryMangaBinding = DataBindingUtil.inflate(LayoutInflater.from(context)
                , R.layout.item_category_manga,parent,false);
        return new ViewHolder(itemCategoryMangaBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).avatar).into(holder.itemCategoryMangaBinding.imageCategoryManga);
        holder.itemCategoryMangaBinding.textViewCategoryManga.setText(arrayList.get(position).name_manga);
    }

    @Override
    public int getItemCount() {
        if(arrayList == null) return 0;
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryMangaBinding itemCategoryMangaBinding;
        public ViewHolder(@NonNull ItemCategoryMangaBinding itemCategoryMangaBinding) {
            super(itemCategoryMangaBinding.getRoot());
            this.itemCategoryMangaBinding = itemCategoryMangaBinding;
        }
    }
}
