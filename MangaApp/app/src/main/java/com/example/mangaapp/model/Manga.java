package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Manga {
    @SerializedName("id_manga")
    public String id_manga;
    @SerializedName("name_manga")
    public String name_manga;
    @SerializedName("avatar")
    public String avatar;
    @SerializedName("url")
    public String url_manga;
    @SerializedName("category")
    public List<String> category;
    @SerializedName("description")
    public String description;
    @SerializedName("view")
    public String views;

    @Override
    public String toString() {
        return "Manga{" +
                "id_manga='" + id_manga + '\'' +
                ", name_manga='" + name_manga + '\'' +
                ", avatar='" + avatar + '\'' +
                ", url_manga='" + url_manga + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", views='" + views + '\'' +
                '}';
    }
}
