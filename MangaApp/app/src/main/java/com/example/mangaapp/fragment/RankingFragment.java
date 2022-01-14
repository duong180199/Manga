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
import com.example.mangaapp.adapter.RankingDayAdapter;
import com.example.mangaapp.databinding.FragmentRankingBinding;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.viewmodel.RankingDayViewModel;

import java.util.ArrayList;

public class RankingFragment extends Fragment implements OnClickListener {
    private FragmentRankingBinding binding;
    private RankingDayViewModel rankingDayViewModel;
    private RankingDayAdapter rankingDayAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ranking,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rankingDayAdapter = new RankingDayAdapter(getContext());
        rankingDayAdapter.setOnClickListener(this);

        rankingDayViewModel = new ViewModelProvider(this).get(RankingDayViewModel.class);

        getData();
    }

    private void getData() {
        rankingDayViewModel.getRankingDay().observe((LifecycleOwner) getContext(), o -> {
            if (o == null ) return;
            rankingDayAdapter.setArrayList((ArrayList<Manga>) o);
        });
        rankingDayViewModel.fetchRankingDay();
        binding.recyclerviewRanking.setAdapter(rankingDayAdapter);
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