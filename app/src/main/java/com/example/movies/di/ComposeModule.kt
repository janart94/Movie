package com.example.movies.di

import com.example.movies.compose.ViewModelActivity
import com.example.movies.compose.ViewModelFragment
import com.example.movies.di.annotations.ActivityScope
import com.example.movies.di.annotations.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ComposeModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelFragment(): ViewModelFragment
}
