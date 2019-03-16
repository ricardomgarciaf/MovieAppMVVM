package com.example.ricardogarcia.movieapp.activities.home.core;

import com.example.ricardogarcia.movieapp.model.Movie;

public interface HomeView {

    void showProgress();

    void hideProgress();

    void setTitleError();

    void showMovie(Movie movie);
}
