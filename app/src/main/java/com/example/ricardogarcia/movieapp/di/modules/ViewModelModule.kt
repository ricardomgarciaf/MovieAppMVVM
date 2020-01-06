package com.example.ricardogarcia.movieapp.di.modules

import com.example.ricardogarcia.movieapp.presentation.viewmodels.MovieSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{

    viewModel {
        MovieSearchViewModel(get())
    }

}