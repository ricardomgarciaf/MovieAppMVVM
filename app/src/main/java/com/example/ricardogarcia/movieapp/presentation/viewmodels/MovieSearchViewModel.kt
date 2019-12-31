package com.example.ricardogarcia.movieapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricardogarcia.movieapp.domain.interactors.SearchMovieUseCases
import com.example.ricardogarcia.movieapp.presentation.entities.ResponseViewModel
import kotlinx.coroutines.*

open class MovieSearchViewModel:ViewModel() {

    private val job = Job()

    private val coroutineExceptionHandler:CoroutineExceptionHandler =
        CoroutineExceptionHandler{_, throwable ->
            viewResource.value = ResponseViewModel.Error()
        }

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job + coroutineExceptionHandler)

    lateinit var searchMovieUseCases: SearchMovieUseCases

    val viewResource:MutableLiveData<ResponseViewModel> = MutableLiveData()

    fun searchMovieByTitle(title:String){
        coroutineScope.launch {
            val movie = withContext(Dispatchers.IO) {
                return@withContext searchMovieUseCases.searchMovieByTitle(title)
            }
            when(movie){
                null-> viewResource.value=ResponseViewModel.Error()
                else->viewResource.value = ResponseViewModel.Success(movie)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}