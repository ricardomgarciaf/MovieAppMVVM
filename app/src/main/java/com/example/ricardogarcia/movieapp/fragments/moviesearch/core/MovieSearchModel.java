package com.example.ricardogarcia.movieapp.fragments.moviesearch.core;

import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MovieSearchModel {
    private OMDBApiInterface api;

    public MovieSearchModel(OMDBApiInterface api){
        this.api=api;
    }

    Disposable search(String title,OnServiceResponseEvent listener){
        if(title.isEmpty()){
            listener.onTitleError();
            return null;
        }

        return api.searchMovieByTitle("17afe84a",title)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess,throwable -> {
                    if(throwable!=null){
                        Timber.e(throwable);
                    }
                    listener.onError();
                });
    }
}
