package com.example.ricardogarcia.movieapp.domain.interactors

import com.example.ricardogarcia.movieapp.domain.entities.MovieModel
import com.example.ricardogarcia.movieapp.model.repositories.MovieRepository
import com.example.ricardogarcia.movieapp.presentation.entities.MovieViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class SearchMovieInteractor(private val movieRepository: MovieRepository):SearchMovieUseCases {

    override suspend fun searchMovieByTitle(title: String): MovieViewModel? {
        val searchMovieByTitle = movieRepository.searchMovieByTitle(title)
        return if(searchMovieByTitle.response) searchMovieByTitle.toMovieViewModel() else null
    }

    fun MovieModel.toMovieViewModel():MovieViewModel{
        val moviePoster=if(poster.equals("N/A")) "" else poster!!
        return MovieViewModel(title!!, year!!, genre!!, plot!!, moviePoster)
    }
}