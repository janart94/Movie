package com.example.movies.mappers

import com.example.movies.models.network.GenresListResponse

class KeywordResponseMapper : NetworkResponseMapper<GenresListResponse> {
    override fun onLastPage(response: GenresListResponse): Boolean {
        return true
    }
}
