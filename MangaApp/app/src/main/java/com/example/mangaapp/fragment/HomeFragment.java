package com.example.mangaapp.fragment;

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

import com.example.mangaapp.R;
import com.example.mangaapp.adapter.BannerAdapter;
import com.example.mangaapp.adapter.HotMangaAdapter;
import com.example.mangaapp.adapter.LikeMangaAdapter;
import com.example.mangaapp.databinding.FragmentHomeBinding;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.HomeBannerViewModel;
import com.example.mangaapp.viewmodel.HomeHotViewModel;
import com.example.mangaapp.viewmodel.HomeLikeViewModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private HomeBannerViewModel homeBannerViewModel;
    private HomeHotViewModel homeHotViewModel;
    private HomeLikeViewModel homeLikeViewModel;

    private BannerAdapter bannerAdapter;
    private HotMangaAdapter hotMangaAdapter;
    private LikeMangaAdapter likeMangaAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bannerAdapter = new BannerAdapter(getContext());
        hotMangaAdapter = new HotMangaAdapter(getContext());

        homeBannerViewModel = new ViewModelProvider(this).get(HomeBannerViewModel.class);
        homeHotViewModel = new ViewModelProvider(this).get(HomeHotViewModel.class);
        homeLikeViewModel = new ViewModelProvider(this).get(HomeLikeViewModel.class);

        getBanner();
        getHotManga();
        getLikeManga();
    }

    public void getBanner(){
        homeBannerViewModel.getManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            bannerAdapter.setMangaArrayList((ArrayList<Manga>) o);
        });
        homeBannerViewModel.fetchBannerManga();
        binding.viewpagerBanner.setAdapter(bannerAdapter);
    }

    public void getHotManga(){
        homeHotViewModel.getHotManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            hotMangaAdapter.setMangaArrayList((ArrayList<Manga>) o);
        });
        homeHotViewModel.fetchHotManga();
        binding.recyclerviewMangaHot.setAdapter(hotMangaAdapter);
    }

    public void getLikeManga(){
        homeLikeViewModel.getLikeManga().observe((LifecycleOwner) getContext(), o -> {
            if(o == null) return;
            likeMangaAdapter.setArrayListLikeManga((ArrayList<Manga>) o);
            Log.d("TAG123", o.toString());
        });
        homeLikeViewModel.fetchLikeManga();
        binding.recyclerviewLikeManga.setAdapter(likeMangaAdapter);
    }

}