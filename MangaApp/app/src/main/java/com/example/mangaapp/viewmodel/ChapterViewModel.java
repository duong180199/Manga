package com.example.mangaapp.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ChapterViewModel extends ViewModel {
    private static Reponsitory reponsitory = new Reponsitory();
    private MutableLiveData<List<String>> _images = new MutableLiveData<>();

    public LiveData<List<String>> images = _images;

    public void fetchImages(int id){
        reponsitory.getImageChapter(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(strings -> _images.postValue(strings))
                .doOnError(throwable -> throwable.printStackTrace()).subscribe();
    }


}
