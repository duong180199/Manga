package com.example.mangaapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Chapter {
    @SerializedName("id_chapter")
    public int idchapter;
    @SerializedName("id_truyen")
    //oik chua. nhung sao no = 0 the trung
    //gia tri mac dinh neu k tim thay
    //nhung e tuong co du lieu thi no phai tim dc chu nhi.sao no tim dc cai name con id cac thu k tim dc
    //trung vua them gach a`.yep. ten sai sao no tim dcok. a` con cai
    public int idtruyen;
    @SerializedName("name")
    public String name;
    @SerializedName("link")
    public ArrayList<String> link;
}
