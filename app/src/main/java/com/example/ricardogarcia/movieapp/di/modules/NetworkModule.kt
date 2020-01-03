package com.example.ricardogarcia.movieapp.di.modules

import com.example.ricardogarcia.movieapp.BuildConfig
import com.example.ricardogarcia.movieapp.model.api.OMDBService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single{
        okHttpClient(get())
    }

    single{
        httpLogginInterceptor()
    }

    single {
        retrofit(get())
    }

    single{
        omdbApiService(get())
    }


}

private fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

private fun httpLogginInterceptor():HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

private fun omdbApiService(retrofit: Retrofit) = retrofit.create(OMDBService::class.java)