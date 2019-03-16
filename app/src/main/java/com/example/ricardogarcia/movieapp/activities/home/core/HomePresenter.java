package com.example.ricardogarcia.movieapp.activities.home.core;

import com.example.ricardogarcia.movieapp.activities.home.HomeActivity;
import com.example.ricardogarcia.movieapp.model.Movie;

import io.reactivex.disposables.Disposable;

public class HomePresenter implements OnServiceResponseEvent{
    private Disposable disposable;
    private HomeActivity view;
    private HomeModel model;

    public HomePresenter(HomeActivity view, HomeModel model){
        this.view=view;
        this.model=model;
    }

    public void onDestroy(){
        if(disposable!=null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    public void searchMovie(String title){
        if(view!=null){
            view.showProgress();
        }
        disposable=model.search(title,this);
    }


    @Override
    public void onTitleError() {
        if(view!=null){
            view.hideProgress();
            view.setTitleError();
        }
    }

    @Override
    public void onSuccess(Movie movie) {
        if(view!=null){
            view.hideProgress();
            view.showMovie(movie);
        }
    }

    @Override
    public void onError() {
        if(view!=null){
            view.hideProgress();
        }
    }
}
