package com.example.ricardogarcia.movieapp

import android.app.Application
import com.example.ricardogarcia.movieapp.di.modules.networkModule
import com.example.ricardogarcia.movieapp.di.modules.repositoryModule
import com.example.ricardogarcia.movieapp.di.modules.useCasesModule
import com.example.ricardogarcia.movieapp.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MovieApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@MovieApplication)
            val moduleList = networkModule + repositoryModule + useCasesModule + viewModelModule
            modules(moduleList)
        }
    }
}