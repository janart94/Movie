package com.example.movies.view.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.movies.models.Resource
import com.example.movies.models.entity.Movie
import com.example.movies.repository.RecentRepository
import com.example.movies.utils.AbsentLiveData
import javax.inject.Inject

class RecentViewModel @Inject constructor(recentRepository: RecentRepository) : ViewModel() {
    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>

    init {
        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let { recentRepository.loadRecentMovie(it) }
                    ?: AbsentLiveData.create()
        }
    }

    fun getMovieListValues() = movieListLiveData.value
    fun postRecentMoviePage(page: Int) = moviePageLiveData.postValue(page)
}
