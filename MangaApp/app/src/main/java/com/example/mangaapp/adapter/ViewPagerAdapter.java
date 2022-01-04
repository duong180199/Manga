package com.example.mangaapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mangaapp.fragment.CategoryFragment;
import com.example.mangaapp.fragment.HomeFragment;
import com.example.mangaapp.fragment.RankingFragment;
import com.example.mangaapp.fragment.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new CategoryFragment();
            case 2:
                return new RankingFragment();
            case 3:
                return new UserFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
