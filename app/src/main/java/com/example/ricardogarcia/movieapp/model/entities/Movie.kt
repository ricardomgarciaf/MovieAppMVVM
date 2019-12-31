package com.example.ricardogarcia.movieapp.model.entities

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val title:String,
    @SerializedName("Year") val year:String,
    @SerializedName("Genre") val genre:String,
    @SerializedName("Plot") val plot:String,
    @SerializedName("Poster") val poster:String,
    @SerializedName("Response") val response:Boolean
)