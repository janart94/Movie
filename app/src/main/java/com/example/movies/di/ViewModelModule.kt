package com.example.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.di.annotations.ViewModelKey
import com.example.movies.view.ui.details.MovieDetailViewModel
import com.example.movies.view.ui.popular.PopularViewModel
import com.example.movies.view.ui.recent.RecentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    internal abstract fun bindMainActivityViewModels(mainActivityViewModel: PopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecentViewModel::class)
    internal abstract fun bindRecentViewModel(recentViewModel: RecentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
