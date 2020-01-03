package com.example.ricardogarcia.movieapp.di.modules

import com.example.ricardogarcia.movieapp.domain.interactors.SearchMovieInteractor
import com.example.ricardogarcia.movieapp.domain.interactors.SearchMovieUseCases
import org.koin.dsl.bind
import org.koin.dsl.module

val useCasesModule = module {

    single{
        SearchMovieInteractor(get())
    } bind SearchMovieUseCases::class
}