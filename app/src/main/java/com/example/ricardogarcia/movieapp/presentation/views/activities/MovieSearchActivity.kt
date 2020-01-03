package com.example.ricardogarcia.movieapp.presentation.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.ricardogarcia.movieapp.R
import com.example.ricardogarcia.movieapp.databinding.ActivityMovieSearchBinding
import com.example.ricardogarcia.movieapp.presentation.entities.ResponseViewModel
import com.example.ricardogarcia.movieapp.presentation.viewmodels.MovieSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieSearchActivity : AppCompatActivity() {

    lateinit var binding:ActivityMovieSearchBinding

    private val viewModel:MovieSearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_search)
        observeViewModel()
        binding.searchBtn.setOnClickListener {
            if(!binding.title.text.toString().isBlank()){
                viewModel.searchMovieByTitle(binding.title.text.toString())
            }else{
                Toast.makeText(this,R.string.empty_title_message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun observeViewModel(){
        viewModel.viewResource.observe(
            this,
            Observer {
                binding.status = it
                when(it){
                    is ResponseViewModel.Success->{
                        binding.movie=it.movie
                    }
                }
            }
        )
    }
}
