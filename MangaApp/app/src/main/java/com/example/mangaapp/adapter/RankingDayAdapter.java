package com.example.mangaapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemRankingMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;
import java.util.Locale;

public class RankingDayAdapter extends RecyclerView.Adapter<RankingDayAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Manga> arrayListManga;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RankingDayAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Manga> arrayList) {
        this.arrayListManga = arrayList;
        notifyDataSetChanged();
    }

    public void updateData(ArrayList<Manga> viewModels) {
        arrayListManga.clear();
        arrayListManga.addAll(viewModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRankingMangaBinding itemRankingMangaBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_ranking_manga,parent,false);
        return new ViewHolder(itemRankingMangaBinding);
    }

    @Override
    public int getItemCount() {
        return arrayListManga != null ? arrayListManga.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setBinding(arrayListManga.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRankingMangaBinding itemRankingMangaBinding;
        public void setBinding(Manga manga){
            itemRankingMangaBinding.setManga(manga);
            itemRankingMangaBinding.executePendingBindings();
            itemRankingMangaBinding.getRoot().setOnClickListener(v -> {
                onClickListener.onClickManga(manga);
            });
        }

        public ViewHolder(@NonNull ItemRankingMangaBinding itemRankingMangaBinding) {
            super(itemRankingMangaBinding.getRoot());
            this.itemRankingMangaBinding = itemRankingMangaBinding;
        }
    }
}
