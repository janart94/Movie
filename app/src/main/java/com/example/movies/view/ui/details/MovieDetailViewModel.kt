package com.example.movies.view.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.movies.models.Genres
import com.example.movies.models.Resource
import com.example.movies.repository.MovieDetailRepository
import com.example.movies.utils.AbsentLiveData
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(repository: MovieDetailRepository) : ViewModel() {

    private val movieIdLiveData: MutableLiveData<Int> = MutableLiveData()
    val genresListLiveData: LiveData<Resource<List<Genres>>>

    init {
        this.genresListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadGenresList(it)
            } ?: AbsentLiveData.create()
        }
    }

    fun postMovieId(id: Int) = movieIdLiveData.postValue(id)
}
