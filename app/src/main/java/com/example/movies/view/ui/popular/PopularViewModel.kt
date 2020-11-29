package com.example.movies.view.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.movies.models.Resource
import com.example.movies.models.entity.Movie
import com.example.movies.repository.PopularRepository
import com.example.movies.utils.AbsentLiveData
import javax.inject.Inject

class PopularViewModel @Inject constructor(popularRepository: PopularRepository) : ViewModel() {
    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>

    init {
        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let { popularRepository.loadPopularMovie(it) }
                    ?: AbsentLiveData.create()
        }
    }

    fun getMovieListValues() = movieListLiveData.value
    fun postPopularMoviePage(page: Int) = moviePageLiveData.postValue(page)
}
