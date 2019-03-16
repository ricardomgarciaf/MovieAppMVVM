package com.example.ricardogarcia.movieapp.application;

import android.app.Application;

import com.example.ricardogarcia.movieapp.BuildConfig;
import com.example.ricardogarcia.movieapp.application.builder.AppComponent;
import com.example.ricardogarcia.movieapp.application.builder.AppModule;
import com.example.ricardogarcia.movieapp.application.builder.DaggerAppComponent;

import timber.log.Timber;

public class MovieApplication extends Application {


    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}
