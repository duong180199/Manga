package com.example.mangaapp.reponsitory;

import android.util.Log;

import com.example.mangaapp.api.Api;
import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Reponsitory {
    private Api api;
    private static Retrofit retrofit = null;

    public Reponsitory() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9:4567/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public Observable<List<Manga>> getBanner(){
        return api.getBannerManga();
    }

    public Observable<List<Manga>> getHotManga(){
        return api.getHotManga();
    }

    public Observable<List<Manga>> getLikeManga(){
        return api.getLikeManga();
    }

    public Observable<List<Manga>> getCategory(String name) {return api.getCategoryManga(name);}

    public Observable<List<Manga>> getRankingDay(){return api.getRankingDayManga();}

    public Observable<Manga> getAllManga(){
        return api.getAllManga();
    }

    public Observable<Chapter> getAllChapter(int id){
        return api.getAllChapterManga(id);
    }

    public Observable<List<Category>> getAllCategory(){
        return api.getAllCategory();
    }


}
