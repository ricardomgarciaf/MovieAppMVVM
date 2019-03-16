package com.example.ricardogarcia.movieapp.application.builder;

import android.content.Context;


import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;

import dagger.Component;

@AppScope
@Component(modules = {ApiServiceModule.class,AppModule.class,NetworkModule.class})
public interface AppComponent {

    Context provideContext();

    OMDBApiInterface apiServiceModule();
}
