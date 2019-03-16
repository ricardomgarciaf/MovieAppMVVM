package com.example.ricardogarcia.movieapp.activities.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ricardogarcia.movieapp.R;
import com.example.ricardogarcia.movieapp.activities.home.core.HomeModel;
import com.example.ricardogarcia.movieapp.activities.home.core.HomePresenter;
import com.example.ricardogarcia.movieapp.activities.home.core.HomeView;
import com.example.ricardogarcia.movieapp.activities.home.dagger.DaggerHomeComponent;
import com.example.ricardogarcia.movieapp.activities.home.dagger.HomeModule;
import com.example.ricardogarcia.movieapp.application.MovieApplication;
import com.example.ricardogarcia.movieapp.databinding.ActivityHomeBinding;
import com.example.ricardogarcia.movieapp.model.InputDetails;
import com.example.ricardogarcia.movieapp.model.Movie;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Inject
    HomeModel model;

    private HomePresenter presenter;

    private ActivityHomeBinding binding;

    private MaterialDialog progressDialog;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHomeComponent.builder().appComponent(MovieApplication.getAppComponent()).homeModule(new HomeModule(this)).build().inject(this);

        progressDialog = new MaterialDialog.Builder(this)
                .title(R.string.loading)
                .progress(true, 0).build();

        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);
        presenter = new HomePresenter(this, model);
        binding.setPresenter(presenter);
        movie= new Movie();
        binding.setMovie(movie);
        binding.setInputdetails(new InputDetails());
    }

    @Override
    protected void onDestroy() {
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
        binding.title.setError(getResources().getString(R.string.title_empty));
    }

    @Override
    public void showMovie(Movie movie) {
        this.movie.setMovie(movie);
    }
}
