package com.example.mangaapp;

import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Chapter;
import com.example.mangaapp.model.Manga;

public interface OnClickListener {
    void onClickManga(Manga manga);
    void  onClickChapter(Chapter chapter);
    void onClickCategory(Category category);
}
