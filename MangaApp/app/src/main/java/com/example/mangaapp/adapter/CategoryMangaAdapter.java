package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemCategoryMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class CategoryMangaAdapter extends RecyclerView.Adapter<CategoryMangaAdapter.ViewHolder> {
    private ArrayList<Manga> arrayList;
    private Context context;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

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
        holder.setBinding(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        if(arrayList == null) return 0;
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryMangaBinding itemCategoryMangaBinding;
        public void setBinding(Manga manga){
            itemCategoryMangaBinding.setManga(manga);
            itemCategoryMangaBinding.executePendingBindings();
            itemCategoryMangaBinding.getRoot().setOnClickListener(v -> {
                onClickListener.onClickManga(manga);
            });
        }
        public ViewHolder(@NonNull ItemCategoryMangaBinding itemCategoryMangaBinding) {
            super(itemCategoryMangaBinding.getRoot());
            this.itemCategoryMangaBinding = itemCategoryMangaBinding;
        }
    }
}
