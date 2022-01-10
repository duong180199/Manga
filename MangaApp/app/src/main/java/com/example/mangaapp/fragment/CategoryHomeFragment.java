package com.example.mangaapp.fragment;

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
import com.example.mangaapp.R;
import com.example.mangaapp.adapter.CategoryMangaAdapter;
import com.example.mangaapp.databinding.FragmentCategoryHomeBinding;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.HomeCategoryViewModel;

import java.util.ArrayList;


public class CategoryHomeFragment extends Fragment {
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

        homeCategoryViewModel = new ViewModelProvider(this).get(HomeCategoryViewModel.class);

        getData();
    }

    private void getData() {
        homeCategoryViewModel.getCategoryManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            ArrayList<Manga> arrayList ;
            arrayList = (ArrayList<Manga>) o;
            binding.textViewCategoryHome.setText("Shoujo");
            binding.textViewTitle.setText(arrayList.get(0).name_manga);
            binding.textViewAvatarDescriiption.setText(arrayList.get(0).description);
            Glide.with(getContext()).load(arrayList.get(0).avatar).into(binding.imageAvatar);
            arrayList.remove(0);
            categoryMangaAdapter.setArrayList(arrayList);
        });
        homeCategoryViewModel.fetchHomeCategory("Shoujo");
        binding.recyclerCategoryHomeManga.setAdapter(categoryMangaAdapter);
    }
}