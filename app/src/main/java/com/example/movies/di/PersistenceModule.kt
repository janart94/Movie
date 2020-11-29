package com.example.movies.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.movies.room.AppDatabase
import com.example.movies.room.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, "TheMovies.db")
                .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(@NonNull database: AppDatabase): MovieDao {
        return database.movieDao()
    }

}
