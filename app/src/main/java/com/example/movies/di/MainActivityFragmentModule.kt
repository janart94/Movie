package com.example.movies.di

import com.example.movies.di.annotations.FragmentScope
import com.example.movies.view.ui.popular.PopularListFragment
import com.example.movies.view.ui.recent.RecentMovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): PopularListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeDatedListFragment(): RecentMovieListFragment

}
