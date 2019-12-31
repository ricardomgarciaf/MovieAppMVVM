package com.example.ricardogarcia.movieapp.domain.interactors

import com.example.ricardogarcia.movieapp.presentation.entities.MovieViewModel

interface SearchMovieUseCases {

    suspend fun searchMovieByTitle(title:String):MovieViewModel?
}