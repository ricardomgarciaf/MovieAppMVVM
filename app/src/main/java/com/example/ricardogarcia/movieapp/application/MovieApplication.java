package com.example.ricardogarcia.movieapp.application;

import android.app.Application;

import com.example.ricardogarcia.movieapp.BuildConfig;

import timber.log.Timber;

public class MovieApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

}
