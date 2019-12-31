package com.example.ricardogarcia.movieapp.application.builder;


import com.example.ricardogarcia.movieapp.model.api.OMDBService;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceModule {


    public OMDBService apiServiceModule(OkHttpClient okHttpClient){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
        return retrofit.create(OMDBService.class);
    }
}
