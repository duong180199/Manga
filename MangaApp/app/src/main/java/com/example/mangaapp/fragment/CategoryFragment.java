package com.example.mangaapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.activity.MangaActivity;
import com.example.mangaapp.adapter.CategoryAdapter;
import com.example.mangaapp.adapter.CategoryMangaAdapter;
import com.example.mangaapp.adapter.RankingDayAdapter;
import com.example.mangaapp.databinding.FragmentCategoryBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.CategoryViewModel;

import java.util.ArrayList;

//xu ly lai ham nay

public class CategoryFragment extends Fragment implements OnClickListener {
    private FragmentCategoryBinding binding;
    private CategoryAdapter categoryAdapter;
    private CategoryViewModel categoryViewModel;
    private RankingDayAdapter rankingDayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_category,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryAdapter = new CategoryAdapter(getContext());
        categoryAdapter.setOnClickListener(this);

        rankingDayAdapter = new RankingDayAdapter(getContext());

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        getDataCategory();
        getMangaCategory();

    }

    private void getMangaCategory() {
        categoryViewModel.fetchMangaCategory("Action").observe((LifecycleOwner) getContext(), mangas -> {
            rankingDayAdapter.setArrayList((ArrayList<Manga>) mangas);
        });
        binding.recyclerCategoryManga.setAdapter(rankingDayAdapter);
    }

    private void getDataCategory() {
        categoryViewModel.fetchCategory().observe((LifecycleOwner) getContext(), categories ->{
            categoryAdapter.setArrayList((ArrayList<Category>) categories);
        } );
        binding.recyclerCategory.setAdapter(categoryAdapter);
    }

    @Override
    public void onClickManga(Manga manga) {
        Intent intent = new Intent(getContext(), MangaActivity.class);
        intent.putExtra("id_manga",manga.id_manga);
        startActivity(intent);
    }

    @Override
    public void onClickChapter(Chapter chapter) {

    }

    @Override
    public void onClickCategory(Category category) {

    }
}