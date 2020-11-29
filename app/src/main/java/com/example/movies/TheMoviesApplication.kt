package com.example.movies

import android.app.Application
import android.os.Build.FINGERPRINT
import com.facebook.stetho.Stetho
import com.example.movies.di.DaggerAppComponent
import dagger.android.DaggerApplication
import timber.log.Timber

@Suppress("unused")
class TheMoviesApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.factory().create(this)

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        if (!isRobolectricUnitTest()) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun isRobolectricUnitTest(): Boolean {
        return "robolectric" == FINGERPRINT
    }

    override fun applicationInjector() = appComponent
}
