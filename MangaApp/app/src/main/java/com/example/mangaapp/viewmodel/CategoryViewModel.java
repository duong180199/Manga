package com.example.mangaapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Category;
import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CategoryViewModel extends ViewModel {
    private Reponsitory reponsitory = new Reponsitory();
    private MutableLiveData<List<Category>> categoryMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Manga>> mangaMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Category>> fetchCategory(){
        reponsitory.getAllCategory().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(categories -> {
                    categoryMutableLiveData.setValue(categories);
                });
        return categoryMutableLiveData;
    }

    public MutableLiveData<List<Manga>> fetchMangaCategory(String name){
        reponsitory.getCategory(name).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(categories -> {
                    mangaMutableLiveData.setValue(categories);
                    Log.d("TAG", "fetchMangaCategory: ");
                });
        return mangaMutableLiveData;
    }

}
