package com.example.mangaapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeHotViewModel extends ViewModel {

    private static Reponsitory reponsitory = new Reponsitory();

    private MutableLiveData<List<Manga>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData getHotManga() {
        return mutableLiveData;
    }

    public void fetchHotManga() {
        reponsitory.getHotManga().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Manga>>() {
                    @Override
                    public void accept(List<Manga> m2) throws Exception {
                        mutableLiveData.setValue(m2);
                    }
                });
    }
}
