package com.example.movies.view.adapter

import android.view.View
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.example.movies.R
import com.example.movies.models.Resource
import com.example.movies.models.entity.Movie
import com.example.movies.view.viewholder.MovieListViewHolder

class MovieListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(resource: Resource<List<Movie>>) {
        resource.data?.let {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view)
}
