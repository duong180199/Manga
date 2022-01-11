package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id_category")
    public Integer idCategory;
    @SerializedName("name")
    public String name;
    @SerializedName("link")
    public String link;
}
