package com.example.mangaapp.api;

import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("manga/manga")
    Observable<Manga> getAllManga();

    @GET("manga/chapter")
    Observable<Chapter> getAllChapterManga(@Path("id_manga") int id);

    @GET("manga/category")
    Observable<Category> getAllCategory();

    @GET("manga/banner")
    Observable<List<Manga>> getBannerManga();

    @GET("manga/hot")
    Observable<List<Manga>> getHotManga();

    @GET("manga/like")
    Observable<List<Manga>> getLikeManga();

    @GET("manga/ranking")
    Observable<List<Manga>> getRankingManga();
}
