package com.example.movies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.api.ApiResponse
import com.example.movies.base.Repository
import com.example.movies.mappers.KeywordResponseMapper
import com.example.movies.models.Genres
import com.example.movies.models.Resource
import com.example.movies.models.network.GenresListResponse
import com.example.movies.room.MovieDao
import com.example.movies.service.MovieService
import com.example.movies.utils.NetworkBoundRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepository @Inject constructor(
        val service: MovieService,
        val movieDao: MovieDao
) : Repository {

    init {
        Timber.d("Injection MovieRepository")
    }

    fun loadGenresList(id: Int): LiveData<Resource<List<Genres>>> {
        return object : NetworkBoundRepository<List<Genres>, GenresListResponse, KeywordResponseMapper>() {
            override fun saveFetchData(items: GenresListResponse) {
                val movie = movieDao.getMovie(id_ = id)
                movie.genres = items.genres
                movieDao.updateMovie(movie = movie)
            }

            override fun shouldFetch(data: List<Genres>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Genres>> {
                val movie = movieDao.getMovie(id_ = id)
                val data: MutableLiveData<List<Genres>> = MutableLiveData()
                data.postValue(movie.genres)
                return data
            }

            override fun fetchService(): LiveData<ApiResponse<GenresListResponse>> {
                return service.fetchKeywords(id = id)
            }

            override fun mapper(): KeywordResponseMapper {
                return KeywordResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }

}
