package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("iduser")
    private Integer iduser;
    @SerializedName("user")
    private String user;
    @SerializedName("pass")
    private String pass;
    @SerializedName("idManga")
    private String idManga;
}
