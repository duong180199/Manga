package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemHotMangaBinding;
import com.example.mangaapp.databinding.ItemNameCategoryBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<Category> arrayList;
    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Category> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNameCategoryBinding itemNameCategoryBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_name_category, parent, false);
        return new ViewHolder(itemNameCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemNameCategoryBinding.buttonCategory.setText(arrayList.get(position).name);
    }

    @Override
    public int getItemCount() {
        if( arrayList == null) return 0;
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemNameCategoryBinding itemNameCategoryBinding;
        public ViewHolder(@NonNull ItemNameCategoryBinding itemNameCategoryBinding) {
            super(itemNameCategoryBinding.getRoot());
            this.itemNameCategoryBinding = itemNameCategoryBinding;
        }
    }
}
