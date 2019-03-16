package com.example.ricardogarcia.movieapp.activities.home.core;

import com.example.ricardogarcia.movieapp.activities.home.HomeActivity;
import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class HomeModel {

    private HomeActivity context;
    private OMDBApiInterface api;

    public HomeModel(HomeActivity context, OMDBApiInterface api){
        this.context=context;
        this.api=api;
    }

    Disposable search(String title, OnServiceResponseEvent listener){
        if(title.isEmpty()){
            listener.onTitleError();
            return null;
        }

        return api.searchMovieByTitle("17afe84a",title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, throwable -> {
                    if(throwable!=null){
                        Timber.e(throwable);
                    }
                    listener.onError();
                });
    }

}
