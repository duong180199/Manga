package com.example.mangaapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeCategoryViewModel extends ViewModel {
    private static Reponsitory reponsitory = new Reponsitory();

    private MutableLiveData<List<Manga>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData getCategoryManga() {
        return mutableLiveData;
    }

    public void fetchHomeCategory(String nameCategory){
        reponsitory.getCategory(nameCategory).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(mangas -> {
                    mutableLiveData.setValue(mangas);
                });
    }
}
