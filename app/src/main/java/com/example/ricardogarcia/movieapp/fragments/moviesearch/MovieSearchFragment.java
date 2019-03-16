package com.example.ricardogarcia.movieapp.fragments.moviesearch;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ricardogarcia.movieapp.R;
import com.example.ricardogarcia.movieapp.application.MovieApplication;
import com.example.ricardogarcia.movieapp.databinding.FragmentMovieSearchBinding;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.core.MovieSearchModel;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.core.MovieSearchPresenter;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.core.MovieSearchView;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.dagger.DaggerMovieSearchComponent;
import com.example.ricardogarcia.movieapp.fragments.moviesearch.dagger.MovieSearchModule;
import com.example.ricardogarcia.movieapp.model.InputDetails;
import com.example.ricardogarcia.movieapp.model.Movie;

import javax.inject.Inject;

public class MovieSearchFragment extends Fragment implements MovieSearchView{

    @Inject
    MovieSearchModel model;

    private MovieSearchPresenter presenter;

    private FragmentMovieSearchBinding binding;

    private MaterialDialog progressDialog;

    private Movie movie;

    public MovieSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_search,container,false);

        progressDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.loading)
                .progress(true, 0).build();

        presenter = new MovieSearchPresenter(this,model);
        binding.setPresenter(presenter);
        movie = new Movie();
        binding.setMovie(movie);
        binding.setInputdetails(new InputDetails());

        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerMovieSearchComponent.builder().appComponent(MovieApplication.getAppComponent()).movieSearchModule(new MovieSearchModule(this)).build().inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setTitleError() {
        binding.title.setError(getResources().getString(R.string.error_message));
    }

    @Override
    public void showMovie(Movie movie) {
        this.movie.setMovie(movie);
    }
}
