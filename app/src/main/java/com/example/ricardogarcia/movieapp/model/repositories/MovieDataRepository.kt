package com.example.ricardogarcia.movieapp.model.repositories

import com.example.ricardogarcia.movieapp.domain.entities.MovieModel
import com.example.ricardogarcia.movieapp.model.api.OMDBService
import com.example.ricardogarcia.movieapp.model.entities.Movie

class MovieDataRepository:MovieRepository {

    lateinit var omdbService: OMDBService

    override suspend fun searchMovieByTitle(title: String): MovieModel {
        return omdbService.searchMovieByTitle(title).toMovieModel()
    }

    fun Movie.toMovieModel():MovieModel{
        return MovieModel(title, year, genre, plot, poster, response)
    }
}