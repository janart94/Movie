package com.example.movies.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movies.models.entity.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM MOVIE WHERE movieId = :id_")
    fun getMovie(id_: Int): Movie

    @Query("SELECT * FROM Movie WHERE page = :page_")
    fun getMovieList(page_: Int): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE page = :page_ AND movieFetchType = :movieFetchType")
    fun getRecentList(page_: Int, movieFetchType: String = "Recent"): LiveData<List<Movie>>
}
