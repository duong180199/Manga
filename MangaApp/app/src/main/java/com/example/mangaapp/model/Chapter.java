package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Chapter {
    @SerializedName("idchapter")
    public int idchapter;
    @SerializedName("idtruyen")
    public int idtruyen;
    @SerializedName("name")
    public String name;
    @SerializedName("link")
    public ArrayList<String> link;
}
