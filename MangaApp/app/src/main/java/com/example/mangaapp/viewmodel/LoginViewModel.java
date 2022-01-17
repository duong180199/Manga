package com.example.mangaapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mangaapp.model.User;
import com.example.mangaapp.reponsitory.Reponsitory;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    private static Reponsitory reponsitory= new Reponsitory();
    private MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

    public boolean fetchUser(String name ,String pass){
        reponsitory.getUser(name,pass).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError(throwable -> throwable.printStackTrace())
                .subscribe(user -> {
                    if(user == null) return;
                    mutableLiveData.setValue(user);
                });
        if(mutableLiveData !=null) return true;
        return false;
    }
}
