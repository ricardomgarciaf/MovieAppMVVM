package com.example.ricardogarcia.movieapp.model.repositories

import com.example.ricardogarcia.movieapp.domain.entities.MovieModel
import com.example.ricardogarcia.movieapp.model.api.OMDBService
import com.example.ricardogarcia.movieapp.model.entities.Movie
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieDataRepository(private val omdbService: OMDBService):MovieRepository {

    override suspend fun searchMovieByTitle(title: String): MovieModel {
        return omdbService.searchMovieByTitle(title).toMovieModel()
    }

    fun Movie.toMovieModel():MovieModel{
        return MovieModel(title, year, genre, plot, poster, response)
    }
}