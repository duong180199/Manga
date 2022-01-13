package com.example.mangaapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.mangaapp.R;
import com.example.mangaapp.adapter.ImageAdapter;
import com.example.mangaapp.databinding.ActivityChapterBinding;
import com.example.mangaapp.viewmodel.ChapterViewModel;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    private ActivityChapterBinding binding;
    private ChapterViewModel chapterViewModel;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        imageAdapter = new ImageAdapter(this);

        chapterViewModel = new ViewModelProvider(this).get(ChapterViewModel.class);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_chapter);

        binding.recyclerImageChapter.setAdapter(imageAdapter);

        observeLiveData();

        getData(46988);
    }

    private void observeLiveData() {
        chapterViewModel.images.observe(this, strings -> {
            if(strings == null) return;
            imageAdapter.setArrayList(strings);
        });
    }

    private void getData(int id) {
        chapterViewModel.fetchImages(id);
    }
}