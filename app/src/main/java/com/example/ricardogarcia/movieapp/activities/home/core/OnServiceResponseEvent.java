package com.example.ricardogarcia.movieapp.activities.home.core;


import com.example.ricardogarcia.movieapp.model.Movie;

public interface OnServiceResponseEvent {
    void onTitleError();

    void onSuccess(Movie movie);

    void onError();
}
