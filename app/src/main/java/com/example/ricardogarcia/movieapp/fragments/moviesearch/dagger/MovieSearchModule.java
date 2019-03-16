package com.example.ricardogarcia.movieapp.fragments.moviesearch.dagger;

import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.MovieSearchFragment;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.core.MovieSearchModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieSearchModule {

    MovieSearchFragment movieSearchFragment;

    public MovieSearchModule(MovieSearchFragment movieSearchFragment){
        this.movieSearchFragment = movieSearchFragment;
    }

    @MovieSearchScope
    @Provides
    MovieSearchFragment provideContext(){
        return movieSearchFragment;
    }

    @MovieSearchScope
    @Provides
    MovieSearchModel provideModel(OMDBApiInterface api){
        return new MovieSearchModel(api);
    }


}
