package com.example.mangaapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends ViewModel {
    private static Reponsitory reponsitory = new Reponsitory();
    private MutableLiveData<List<Manga>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Manga>> fetchListManga(String name){
        reponsitory.getSearch(name).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError(throwable -> throwable.printStackTrace())
                .subscribe(mangas -> {
                   mutableLiveData.setValue(mangas);
                });
        return mutableLiveData;
    }
}
