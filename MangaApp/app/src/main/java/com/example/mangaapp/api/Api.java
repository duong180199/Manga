package com.example.mangaapp.api;

import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;


import io.reactivex.Observable;
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
    Observable<Manga> getBannerManga();

}
