package com.example.movies.service

import androidx.lifecycle.LiveData
import com.example.movies.api.ApiResponse
import com.example.movies.models.network.GenresListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("/3/movie/{movie_id}")
    fun fetchKeywords(@Path("movie_id") id: Int, @Query("append_to_response") genres: String = "genres"): LiveData<ApiResponse<GenresListResponse>>
}
