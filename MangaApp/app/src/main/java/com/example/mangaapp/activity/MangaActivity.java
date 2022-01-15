package com.example.mangaapp.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.adapter.ChapterAdapter;
import com.example.mangaapp.databinding.ActivityMangaBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.MangaViewModel;

import java.util.ArrayList;

public class MangaActivity extends AppCompatActivity implements OnClickListener {
    private ActivityMangaBinding binding;
    private MangaViewModel mangaViewModel;
    private ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);

        chapterAdapter = new ChapterAdapter(this);
        chapterAdapter.setOnClickListener(this);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_manga);

        mangaViewModel = new ViewModelProvider(this).get(MangaViewModel.class);

        binding.recyclerChapter.setAdapter(chapterAdapter);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id_manga");
        getData(Integer.parseInt(id));

    }

    private void getData(int id) {
        mangaViewModel.fetchManga(id).observe(this,manga1 -> {
            if(manga1 == null) return;
            binding.setManga(manga1);
        });

        mangaViewModel.fetchMangaChapter(id).observe(this,chapters -> {
            if(chapters == null) return;
            chapterAdapter.setArrayList((ArrayList<Chapter>) chapters);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClickManga(Manga manga) {}

    @Override
    public void onClickChapter(Chapter chapter) {
        Intent intent = new Intent(this,ChapterActivity.class);
        intent.putExtra("id_chapter",String.valueOf(chapter.idchapter));//cai nay == null
        startActivity(intent);
    }

    @Override
    public void onClickCategory(Category category) {

    }//sa
}