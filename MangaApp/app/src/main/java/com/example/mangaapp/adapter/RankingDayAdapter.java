package com.example.mangaapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemRankingMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class RankingDayAdapter extends RecyclerView.Adapter<RankingDayAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Manga> arrayList;

    public RankingDayAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Manga> arrayList) {
        this.arrayList = arrayList;
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
        if(arrayList == null) return 0;
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemRankingMangaBinding.textViewNameRankingManga.setText(arrayList.get(position).name_manga);
        holder.itemRankingMangaBinding.textViewManga.setText(arrayList.get(position).views);
//        Log.d("BBB", arrayList.get(position).views);
        holder.itemRankingMangaBinding.textViewCategoryManga.setText(arrayList.get(position).category.toString());
        Glide.with(context).load(arrayList.get(position).avatar).into(holder.itemRankingMangaBinding.imageViewRanking);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRankingMangaBinding itemRankingMangaBinding;
        public ViewHolder(@NonNull ItemRankingMangaBinding itemRankingMangaBinding) {
            super(itemRankingMangaBinding.getRoot());
            this.itemRankingMangaBinding = itemRankingMangaBinding;
        }
    }
}
