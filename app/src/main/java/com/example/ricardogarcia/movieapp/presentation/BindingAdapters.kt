package com.example.ricardogarcia.movieapp.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.ricardogarcia.movieapp.presentation.entities.ResponseViewModel
import com.squareup.picasso.Picasso

@BindingAdapter("loadingState")
fun setLoadingState(view: View, responseViewModel: ResponseViewModel?){
    view.visibility = when(responseViewModel){
        is ResponseViewModel.Loading -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("errorState")
fun setErrorState(view:View, responseViewModel: ResponseViewModel?){
    view.visibility = when(responseViewModel){
        is ResponseViewModel.Error -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("successState")
fun setSuccessState(view:View, responseViewModel: ResponseViewModel?){
    view.visibility = when(responseViewModel){
        is ResponseViewModel.Success -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("poster")
fun setPoster(imageView: ImageView, poster:String?){
    if(!poster.isNullOrBlank()) {
        imageView.visibility = View.VISIBLE
        Picasso.get().load(poster).into(imageView)
    }else{
        imageView.visibility = View.GONE
    }
}