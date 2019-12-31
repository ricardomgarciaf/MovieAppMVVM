package com.example.ricardogarcia.movieapp.domain.interactors

import com.example.ricardogarcia.movieapp.domain.entities.MovieModel
import com.example.ricardogarcia.movieapp.model.repositories.MovieRepository
import com.example.ricardogarcia.movieapp.presentation.entities.MovieViewModel

class SearchMovieInteractor:SearchMovieUseCases {

    lateinit var movieRepository: MovieRepository

    override suspend fun searchMovieByTitle(title: String): MovieViewModel? {
        val searchMovieByTitle = movieRepository.searchMovieByTitle(title)
        return if(searchMovieByTitle.response) searchMovieByTitle.toMovieViewModel() else null
    }

    fun MovieModel.toMovieViewModel():MovieViewModel{
        return MovieViewModel(title, year, genre, plot, poster)
    }
}