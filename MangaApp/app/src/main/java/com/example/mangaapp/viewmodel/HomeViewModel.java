package com.example.mangaapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.Manga;
import com.example.mangaapp.reponsitory.Reponsitory;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private final Reponsitory reponsitory = new Reponsitory();

    private MutableLiveData<Manga> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData getManga() {
        return mutableLiveData;
    }

    public void fetchBanner() {
        reponsitory.getBanner().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Manga>() {
                    @Override
                    public void accept(Manga manga) throws Exception {
                        mutableLiveData.setValue(manga);
                    }
                });
    }
}
