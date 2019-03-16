package com.example.ricardogarcia.movieapp.activities.home.dagger;

import com.example.ricardogarcia.movieapp.activities.home.HomeActivity;
import com.example.ricardogarcia.movieapp.activities.home.core.HomeModel;
import com.example.ricardogarcia.movieapp.api.OMDBApiInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    HomeActivity homeActivity;

    public HomeModule(HomeActivity homeActivity){
        this.homeActivity=homeActivity;
    }

    @HomeScope
    @Provides
    HomeActivity provideContext(){
       return homeActivity;
    }

    @HomeScope
    @Provides
    HomeModel provideModel(OMDBApiInterface api){
        return new HomeModel(homeActivity,api);
    }
}
