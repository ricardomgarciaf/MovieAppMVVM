package com.example.ricardogarcia.movieapp.model.repositories

import com.example.ricardogarcia.movieapp.domain.entities.MovieModel

interface MovieRepository {

    suspend fun searchMovieByTitle(title:String):MovieModel
}