package com.example.ricardogarcia.movieapp.model.api

import com.example.ricardogarcia.movieapp.model.entities.Movie
import retrofit2.http.GET
import retrofit2.http.Query

const val apivalue="17afe84a"

interface OMDBService {
    @GET(".")
    suspend fun searchMovieByTitle(@Query("t") title:String, @Query("apikey") apikey:String = apivalue): Movie
}