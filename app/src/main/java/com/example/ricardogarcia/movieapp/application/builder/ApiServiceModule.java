package com.example.ricardogarcia.movieapp.application.builder;

import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModule {

    @AppScope
    @Provides
    public OMDBApiInterface apiServiceModule(OkHttpClient okHttpClient){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
        return retrofit.create(OMDBApiInterface.class);
    }
}
