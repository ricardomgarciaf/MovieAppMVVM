package com.example.ricardogarcia.movieapp.presentation.entities

sealed class ResponseViewModel{
    class Success(val movie:MovieViewModel):ResponseViewModel()
    class Loading:ResponseViewModel()
    class Error:ResponseViewModel()
}