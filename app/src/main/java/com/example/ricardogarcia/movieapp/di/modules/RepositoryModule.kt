package com.example.ricardogarcia.movieapp.di.modules

import com.example.ricardogarcia.movieapp.model.repositories.MovieDataRepository
import com.example.ricardogarcia.movieapp.model.repositories.MovieRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {

    single{
        MovieDataRepository(get())
    } bind MovieRepository::class

}