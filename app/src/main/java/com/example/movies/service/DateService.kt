package com.example.movies.service

import androidx.lifecycle.LiveData
import com.example.movies.api.ApiResponse
import com.example.movies.models.network.DiscoverMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DateService {
    @GET("/3/discover/movie?language=en&year=2020")
    fun fetchDateMovie(@Query("page") page: Int, @Query("sort_by") sortCategory: String = "release_date.desc"): LiveData<ApiResponse<DiscoverMovieResponse>>
}
