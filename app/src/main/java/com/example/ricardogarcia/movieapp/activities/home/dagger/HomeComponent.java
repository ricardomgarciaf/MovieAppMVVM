package com.example.ricardogarcia.movieapp.activities.home.dagger;

import com.example.ricardogarcia.movieapp.activities.home.HomeActivity;
import com.example.ricardogarcia.movieapp.application.builder.AppComponent;

import dagger.Component;

@HomeScope
@Component(dependencies = {AppComponent.class}, modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
