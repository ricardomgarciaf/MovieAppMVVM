package com.example.ricardogarcia.movieapp.fragments.moviesearch.core;

import com.example.ricardogarcia.movieapp.model.Movie;

public interface MovieSearchView {

    void showProgress();

    void hideProgress();

    void setTitleError();

    void showMovie(Movie movie);

}
