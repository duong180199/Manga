package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Chapter {
    @SerializedName("idchapter")
    private int idchapter;
    @SerializedName("idtruyen")
    private int idtruyen;
    @SerializedName("name")
    private String name;
    @SerializedName("link")
    private ArrayList<String> link;
}
