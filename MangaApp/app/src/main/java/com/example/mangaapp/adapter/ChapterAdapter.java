package com.example.mangaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ItemChapterBinding;
import com.example.mangaapp.model.Chapter;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Chapter> arrayList;

    public ChapterAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Chapter> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChapterBinding itemChapterBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_chapter,parent,false);

        return new ViewHolder(itemChapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemChapterBinding.textViewNameChapter.setText(arrayList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrayList != null ? arrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemChapterBinding itemChapterBinding;
        public ViewHolder(@NonNull ItemChapterBinding itemChapterBinding) {
            super(itemChapterBinding.getRoot());
            this.itemChapterBinding = itemChapterBinding;
        }
    }
}
