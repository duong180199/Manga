package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemRankingMangaBinding;

import java.util.ArrayList;

public abstract class RankingAdapter <T,VM extends ItemRankingMangaBinding> extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private Context context;
    private ArrayList<T> arrayList;
    @NonNull
    @Override
    public ViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRankingMangaBinding itemRankingMangaBinding = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_ranking_manga,parent,false);
        return new ViewHolder<T>(itemRankingMangaBinding);
    }

    @Override
    public int getItemCount() {
        if(arrayList == null) return 0;
        return arrayList.size();
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder<T> holder, int position) {
//
//    }

    public class ViewHolder<T> extends RecyclerView.ViewHolder {
        VM itemRankingMangaBinding;
        public ViewHolder(@NonNull ItemRankingMangaBinding itemRankingMangaBinding) {
            super(itemRankingMangaBinding.getRoot());
        }
    }
}
