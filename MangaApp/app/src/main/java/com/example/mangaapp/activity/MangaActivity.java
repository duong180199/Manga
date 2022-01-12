package com.example.mangaapp.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mangaapp.R;
import com.example.mangaapp.adapter.ChapterAdapter;
import com.example.mangaapp.databinding.ActivityMangaBinding;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.MangaViewModel;

import java.util.ArrayList;

public class MangaActivity extends AppCompatActivity {
    private ActivityMangaBinding binding;
    private MangaViewModel mangaViewModel;
    private ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);
        chapterAdapter = new ChapterAdapter(this);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_manga);

        mangaViewModel = new ViewModelProvider(this).get(MangaViewModel.class);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getData(22089);
    }

    private void getData(int id) {
        mangaViewModel.fetchManga(id).observe(this,manga1 -> {
            if(manga1 == null) return;
            binding.textViewName.setText(manga1.name_manga);
            binding.textViewNameCategory.setText(manga1.category.toString());
            binding.textViewRead.setText(manga1.views);
            binding.textViewDescription.setText(manga1.description);
            Glide.with(this).load(manga1.avatar).into(binding.imageMangaAvatar);
        });

        mangaViewModel.fetchMangaChapter(id).observe(this,chapters -> {
            if(chapters == null) return;
            chapterAdapter.setArrayList((ArrayList<Chapter>) chapters);
            binding.recyclerChapter.setAdapter(chapterAdapter);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}