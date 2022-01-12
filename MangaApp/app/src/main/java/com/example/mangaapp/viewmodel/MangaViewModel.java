package com.example.mangaapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MangaViewModel extends ViewModel {
    private static Reponsitory reponsitory = new Reponsitory();
    private MutableLiveData<Manga> mangaMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Chapter>> chapterMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Manga> fetchManga(int id){
        reponsitory.getManga(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(manga -> {
                    mangaMutableLiveData.setValue(manga);
                });
        return mangaMutableLiveData;
    }

    public MutableLiveData<List<Chapter>> fetchMangaChapter(int id){
        reponsitory.getMangaChapter(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(chapters -> {
                    chapterMutableLiveData.setValue((List<Chapter>) chapters);
                });
        return chapterMutableLiveData;
    }
}
