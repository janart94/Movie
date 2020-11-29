package com.example.movies.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.example.movies.R
import com.example.movies.api.Api
import com.example.movies.models.entity.Movie
import com.example.movies.view.ui.main.MovieDetailActivity
import kotlinx.android.synthetic.main.item_poster.view.*

class MovieListViewHolder constructor(
        val view: View
) : BaseViewHolder(view) {

    private lateinit var movie: Movie

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Movie) {
            movie = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            movie.poster_path?.let {
                Glide.with(context)
                        .load(Api.getPosterPath(it))
                        .placeholder(R.drawable.placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(item_poster_post)
            }
        }
    }

    override fun onClick(v: View?) = MovieDetailActivity.startActivityModel(context(), movie)

    override fun onLongClick(v: View?) = false
}
