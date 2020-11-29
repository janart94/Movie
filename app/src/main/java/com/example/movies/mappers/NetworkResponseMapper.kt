package com.example.movies.mappers

import com.example.movies.models.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
    fun onLastPage(response: FROM): Boolean
}
