package com.example.mangaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.activity.MangaActivity;
import com.example.mangaapp.model.Manga;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    private ArrayList<Manga> mangaArrayList;
    private Context context;
    private OnClickListener onClickListener;
    public BannerAdapter(Context context) {
        this.context = context;
    }

    public void setMangaArrayList(ArrayList<Manga> mangaArrayList) {
        this.mangaArrayList = mangaArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner_manga,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Manga manga = mangaArrayList.get(position);
        Glide.with(context).load(manga.avatar).into(holder.imageAvatar);
        holder.textName.setText(manga.name_manga);
        holder.textDescription.setText(manga.description);
        holder.imageAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(context, MangaActivity.class);
            intent.putExtra("id_manga", mangaArrayList.get(position).id_manga);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if(mangaArrayList == null) return 0;
        return mangaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageAvatar;
        private TextView textName,textDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.image_banner_manga);
            textName = itemView.findViewById(R.id.text_view_name_manga);
            textDescription = itemView.findViewById(R.id.text_view_description);
        }
    }
}
