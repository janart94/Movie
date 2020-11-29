package com.example.movies.view.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.movies.R
import com.example.movies.databinding.ActivityMainBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>
    lateinit var navController: NavController
    override fun androidInjector() = fragmentInjector
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        var navHostFragment = supportFragmentManager.findFragmentById(R.id.navController) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)
    }


}
