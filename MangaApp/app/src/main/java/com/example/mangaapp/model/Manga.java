package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

public class Manga {
    @SerializedName("id_manga")
    private int id_manga;
    @SerializedName("name_manga")
    private String name_manga;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("url")
    private String url_manga;
    @SerializedName("category")
    private String id_category;
    @SerializedName("description")
    private String description;

    public int getId_manga() {
        return id_manga;
    }

    public void setId_manga(int id_manga) {
        this.id_manga = id_manga;
    }

    public String getName_manga() {
        return name_manga;
    }

    public void setName_manga(String name_manga) {
        this.name_manga = name_manga;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl_manga() {
        return url_manga;
    }

    public void setUrl_manga(String url_manga) {
        this.url_manga = url_manga;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
