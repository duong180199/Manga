package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemLikeMangaBinding;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class LikeMangaAdapter extends RecyclerView.Adapter<LikeMangaAdapter.ViewHolder> {
    private ArrayList<Manga> arrayListLikeManga = new ArrayList<>();
    private Context context;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

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
        holder.setBinding(arrayListLikeManga.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayListLikeManga == null ? 0 :arrayListLikeManga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLikeMangaBinding itemLikeMangaBinding;
        public void setBinding(Manga manga){
            itemLikeMangaBinding.setManga(manga);
            itemLikeMangaBinding.executePendingBindings();
            itemLikeMangaBinding.getRoot().setOnClickListener(v -> {
                 onClickListener.onClickManga(manga);
            });
        }

        public ViewHolder(@NonNull ItemLikeMangaBinding itemLikeMangaBinding) {
            super(itemLikeMangaBinding.getRoot());
            this.itemLikeMangaBinding = itemLikeMangaBinding;

        }
    }
}
