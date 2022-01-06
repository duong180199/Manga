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
                .baseUrl("http://10.0.2.2:4567/")
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

    public Observable<Manga> getAllManga(){
        return api.getAllManga();
    }

    public Observable<Chapter> getAllChapter(int id){
        return api.getAllChapterManga(id);
    }

    public Observable<Category> getAllCategory(){
        return api.getAllCategory();
    }


}
