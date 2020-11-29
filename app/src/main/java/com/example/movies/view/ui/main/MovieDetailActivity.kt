package com.example.movies.view.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.example.movies.R
import com.example.movies.compose.ViewModelActivity
import com.example.movies.databinding.ActivityMovieDetailBinding
import com.example.movies.extension.applyToolbarMargin
import com.example.movies.extension.simpleToolbarWithHome
import com.example.movies.models.entity.Movie
import com.example.movies.view.ui.details.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : ViewModelActivity() {

    private val viewModel: MovieDetailViewModel by injectViewModels()

    lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = binding(R.layout.activity_movie_detail)
        binding.run {
            lifecycleOwner = this@MovieDetailActivity
            viewModel = this@MovieDetailActivity.viewModel.apply { postMovieId(getMovieFromIntent().movieId) }
            movie = getMovieFromIntent()
        }
        initializeUI()
    }

    private fun initializeUI() {
        applyToolbarMargin(binding.movieDetailToolbar)
        simpleToolbarWithHome(binding.movieDetailToolbar, getMovieFromIntent().title)
    }

    private fun getMovieFromIntent() = intent.getParcelableExtra(movieId) as Movie

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) onBackPressed()
        return false
    }

    companion object {
        private const val movieId = "movie"
        fun startActivityModel(context: Context?, movie: Movie) {
            context?.let {
                val intent = Intent(it, MovieDetailActivity::class.java).apply { putExtra(movieId, movie) }
                it.startActivity(intent)
            }
        }
    }
}
