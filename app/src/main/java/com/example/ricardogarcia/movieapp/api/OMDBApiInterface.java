package com.example.ricardogarcia.movieapp.api;


import com.example.ricardogarcia.movieapp.model.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OMDBApiInterface {

    @GET(".")
    Observable<Movie> searchMovieByTitle(@Query("apikey")String apikey, @Query("t") String title);
}
