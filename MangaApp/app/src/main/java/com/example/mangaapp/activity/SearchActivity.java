package com.example.mangaapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.adapter.RankingDayAdapter;
import com.example.mangaapp.databinding.ActivitySearchBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.SearchViewModel;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, OnClickListener {

    private ActivitySearchBinding binding;
    private SearchViewModel searchViewModel;
    private RankingDayAdapter rankingDayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_search);
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        rankingDayAdapter = new RankingDayAdapter(this);
        rankingDayAdapter.setOnClickListener(this);
        binding.recyclerSearch.setAdapter(rankingDayAdapter);
        binding.searchview.setOnQueryTextListener(this);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void getData(String name) {
        if(name.equals("")) name = "a";
        searchViewModel.fetchListManga(name).observe(this,mangas -> {
            if(mangas == null) return;
            rankingDayAdapter.setArrayList((ArrayList<Manga>) mangas);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        getData(newText);
        return false;
    }

    @Override
    public void onClickManga(Manga manga) {
        Intent intent = new Intent(this, MangaActivity.class);
        intent.putExtra("id_manga",manga.id_manga.toString());
        startActivity(intent);
    }

    @Override
    public void onClickChapter(Chapter chapter) {

    }

    @Override
    public void onClickCategory(Category category) {

    }
}