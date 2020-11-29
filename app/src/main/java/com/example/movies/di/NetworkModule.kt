package com.example.movies.di

import androidx.annotation.NonNull
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.example.movies.api.LiveDataCallAdapterFactory
import com.example.movies.api.RequestInterceptor
import com.example.movies.service.DateService
import com.example.movies.service.MovieService
import com.example.movies.service.PopularService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    fun provideDiscoverService(@NonNull retrofit: Retrofit): PopularService {
        return retrofit.create(PopularService::class.java)
    }

    @Provides
    @Singleton
    fun provideDateService(@NonNull retrofit: Retrofit): DateService {
        return retrofit.create(DateService::class.java)
    }


    @Provides
    @Singleton
    fun provideMovieService(@NonNull retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }


}
