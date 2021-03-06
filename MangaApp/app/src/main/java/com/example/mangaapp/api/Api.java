package com.example.mangaapp.api;

import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.model.User;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @POST("manga/manga/{id_manga}")
    Observable<Manga> getManga(@Path("id_manga") int id);

    @POST("manga/chapter/{id_manga}")
    Observable<List<Chapter>> getMangaChapter(@Path("id_manga") int id);

    @GET("manga/category")
    Observable<List<Category>> getAllCategory();

    @POST("manga/category/{name}")
    Observable<List<Manga>> getCategoryManga(@Path("name") String name);

    @GET("manga/banner")
    Observable<List<Manga>> getBannerManga();

    @GET("manga/hot")
    Observable<List<Manga>> getHotManga();

    @GET("manga/like")
    Observable<List<Manga>> getLikeManga();

    @GET("manga/ranking/day")
    Observable<List<Manga>> getRankingDayManga();

    @POST("manga/chapter/image/{idchapter}")
    Observable<List<String>> getImageChapter(@Path("idchapter") int idchapter);

    @POST("manga/search/{name}")
    Observable<List<Manga>> getSearch(@Path("name") String name);

    @POST("user/login")
    Observable<User> getUser(@Query("username") String username,@Query("password") String password);
}
