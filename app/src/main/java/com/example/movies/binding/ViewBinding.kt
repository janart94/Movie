package com.example.movies.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.chip.ChipGroup
import com.example.movies.R
import com.example.movies.api.Api
import com.example.movies.extension.addPrimaryChip
import com.example.movies.extension.bindResource
import com.example.movies.extension.requestGlideListener
import com.example.movies.extension.visible
import com.example.movies.models.Genres
import com.example.movies.models.Resource
import com.example.movies.models.entity.Movie

@BindingAdapter("mapKeywordList")
fun bindMapKeywordList(view: ChipGroup, resource: Resource<List<Genres>>?) {
    view.bindResource(resource) {
        it.data?.let { keywords ->
            if (keywords.isNotEmpty()) {
                view.visible()
                keywords.forEach { keyword -> view.addPrimaryChip(keyword.name) }
            }
        }
    }
}


@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
    if (movie.backdrop_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(movie.backdrop_path))
                .placeholder(R.drawable.placeholder)
                .listener(view.requestGlideListener())
                .into(view)
    } else {
        Glide.with(view.context).load(Api.getBackdropPath(movie.poster_path!!))
                .placeholder(R.drawable.placeholder)
                .listener(view.requestGlideListener())
                .into(view)
    }
}
