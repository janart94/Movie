package com.example.movies.models.network

import com.example.movies.models.Genres
import com.example.movies.models.NetworkResponseModel

data class GenresListResponse(
        val id: Int,
        val genres: List<Genres>
) : NetworkResponseModel
