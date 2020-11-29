package com.example.movies.models.network

import com.example.movies.models.NetworkResponseModel
import com.example.movies.models.entity.Movie

data class DiscoverMovieResponse(
        val page: Int,
        val results: List<Movie>,
        val total_results: Int,
        val total_pages: Int
) : NetworkResponseModel
