package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemHotMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;


public class HotMangaAdapter extends RecyclerView.Adapter<HotMangaAdapter.ViewHolder>{
    private ArrayList<Manga> mangaArrayList;
    private Context context;
    private OnClickListener onClickListener;

    public HotMangaAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
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
        holder.setBinding(mangaArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mangaArrayList != null  ? mangaArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemHotMangaBinding itemHotMangaBinding;
        public void setBinding(Manga manga){
            itemHotMangaBinding.setManga(manga);
            itemHotMangaBinding.executePendingBindings();
            itemHotMangaBinding.getRoot().setOnClickListener(v -> {
                if (onClickListener == null) return;
                onClickListener.onClickManga(manga);
            });
        }
        public ViewHolder(@NonNull ItemHotMangaBinding ItemHotMangaBinding) {
            super(ItemHotMangaBinding.getRoot());
            this.itemHotMangaBinding = ItemHotMangaBinding;
        }
    }
}
