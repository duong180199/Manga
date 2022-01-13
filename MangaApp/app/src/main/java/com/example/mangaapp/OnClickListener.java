package com.example.mangaapp;

import com.example.mangaapp.model.Manga;

public interface OnClickListener<T extends Manga> {
    void onClick(T t);

}
