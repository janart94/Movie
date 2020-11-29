package com.example.movies.di

import com.example.movies.di.annotations.ActivityScope
import com.example.movies.view.ui.main.MainActivity
import com.example.movies.view.ui.main.MovieDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeMovieDetailActivity(): MovieDetailActivity

}
