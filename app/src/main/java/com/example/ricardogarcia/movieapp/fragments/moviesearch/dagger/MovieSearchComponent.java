package com.example.ricardogarcia.movieapp.fragments.moviesearch.dagger;

import com.example.ricardogarcia.movieapp.application.builder.AppComponent;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.MovieSearchFragment;

import dagger.Component;

@MovieSearchScope
@Component(dependencies = {AppComponent.class}, modules = {MovieSearchModule.class})
public interface MovieSearchComponent {
    void inject(MovieSearchFragment movieSearchFragment);
}
