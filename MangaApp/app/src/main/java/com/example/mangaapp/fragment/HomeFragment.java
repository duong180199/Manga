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
import com.example.mangaapp.databinding.FragmentHomeBinding;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.HomeViewModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private BannerAdapter bannerAdapter;
    private HotMangaAdapter hotMangaAdapter;

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

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        getBanner();
        getHotManga();



    }

    public void getBanner(){
        homeViewModel.getManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            bannerAdapter.setMangaArrayList((ArrayList<Manga>) o);
        });
        homeViewModel.fetchBannerManga();
        binding.viewpagerBanner.setAdapter(bannerAdapter);
    }

    public void getHotManga(){
        homeViewModel.getManga().observe((LifecycleOwner) getContext(), o -> {
            if (o == null) return;
            hotMangaAdapter.setMangaArrayList((ArrayList<Manga>) o);
        });
        homeViewModel.fetchHotManga();
        binding.recyclerviewMangaHot.setAdapter(hotMangaAdapter);
    }

}