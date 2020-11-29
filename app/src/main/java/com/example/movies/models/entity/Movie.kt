package com.example.movies.models.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movies.models.Genres
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Movie(
        @PrimaryKey(autoGenerate = true)
        val movieId: Int,
        val id: Int,
        var page: Int,
        var genres: List<Genres>? = ArrayList(),
        val poster_path: String?,
        val adult: Boolean,
        val overview: String,
        val release_date: String?,
        val genre_ids: List<Int>,
        val original_title: String,
        val original_language: String,
        val title: String,
        val backdrop_path: String?,
        val popularity: Float,
        val vote_count: Int,
        val video: Boolean,
        val vote_average: Float,
        @ColumnInfo(defaultValue = "popular")
        var movieFetchType: String = ""
) : Parcelable
