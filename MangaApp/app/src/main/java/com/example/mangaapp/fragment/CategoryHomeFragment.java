package com.example.mangaapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mangaapp.OnClickListener;
import com.example.mangaapp.R;
import com.example.mangaapp.activity.MangaActivity;
import com.example.mangaapp.adapter.CategoryMangaAdapter;
import com.example.mangaapp.databinding.FragmentCategoryHomeBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.HomeCategoryViewModel;

import java.util.ArrayList;


public class CategoryHomeFragment extends Fragment implements OnClickListener  {
    private FragmentCategoryHomeBinding binding;
    private HomeCategoryViewModel homeCategoryViewModel;
    private CategoryMangaAdapter categoryMangaAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_home, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryMangaAdapter = new CategoryMangaAdapter(getContext());
        categoryMangaAdapter.setOnClickListener(this);

        homeCategoryViewModel = new ViewModelProvider(this).get(HomeCategoryViewModel.class);


        getData();
    }

    private void getData() {
        homeCategoryViewModel.getCategoryManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            ArrayList<Manga> arrayList ;
            arrayList = (ArrayList<Manga>) o;
            binding.textViewCategoryHome.setText("Shoujo");
            binding.setManga(arrayList.get(0));
            binding.imageAvatar.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), MangaActivity.class);
                intent.putExtra("id_manga",arrayList.get(0).id_manga);
                startActivity(intent);
            });
            arrayList.remove(0);
            categoryMangaAdapter.setArrayList(arrayList);
        });
        homeCategoryViewModel.fetchHomeCategory("Shoujo");
        binding.recyclerCategoryHomeManga.setAdapter(categoryMangaAdapter);
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