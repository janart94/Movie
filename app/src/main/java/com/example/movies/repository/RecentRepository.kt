package com.example.movies.repository

import androidx.lifecycle.LiveData
import com.example.movies.api.ApiResponse
import com.example.movies.base.Repository
import com.example.movies.mappers.MovieResponseMapper
import com.example.movies.models.Resource
import com.example.movies.models.entity.Movie
import com.example.movies.models.network.DiscoverMovieResponse
import com.example.movies.room.MovieDao
import com.example.movies.service.DateService
import com.example.movies.utils.NetworkBoundRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecentRepository @Inject constructor(
        val discoverService: DateService,
        val movieDao: MovieDao) : Repository {

    fun loadRecentMovie(page: Int): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundRepository<List<Movie>, DiscoverMovieResponse, MovieResponseMapper>() {
            override fun saveFetchData(items: DiscoverMovieResponse) {
                for (item in items.results) {
                    item.page = page
                    item.movieFetchType = "Recent"
                }
                movieDao.insertMovieList(movies = items.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieDao.getRecentList(page_ = page)
            }

            override fun fetchService(): LiveData<ApiResponse<DiscoverMovieResponse>> {
                return discoverService.fetchDateMovie(page = page)
            }

            override fun mapper(): MovieResponseMapper {
                return MovieResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed $message")
            }
        }.asLiveData()
    }

}
