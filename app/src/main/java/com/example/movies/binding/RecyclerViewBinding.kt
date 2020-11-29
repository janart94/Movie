package com.example.movies.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.example.movies.extension.bindResource
import com.example.movies.models.Resource
import com.example.movies.models.Status
import com.example.movies.models.entity.Movie
import com.example.movies.view.adapter.MovieListAdapter
import com.example.movies.view.adapter.RecentListAdapter
import com.example.movies.view.ui.popular.PopularViewModel
import com.example.movies.view.ui.recent.RecentViewModel

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: BaseAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: Resource<List<Movie>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(it)
    }
}


@BindingAdapter("adapterDateList")
fun bindAdapterDateList(view: RecyclerView, resource: Resource<List<Movie>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? RecentListAdapter
        adapter?.addMovieList(it)
    }
}

@BindingAdapter("moviePopularPagination")
fun bindPopulatePagination(view: RecyclerView, viewModel: PopularViewModel) {
    RecyclerViewPaginator(
            recyclerView = view,
            isLoading = { viewModel.getMovieListValues()?.status == Status.LOADING },
            loadMore = { viewModel.postPopularMoviePage(it) },
            onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("movieRecentPagination")
fun bindRecentPagination(view: RecyclerView, viewModel: RecentViewModel) {
    RecyclerViewPaginator(
            recyclerView = view,
            isLoading = { viewModel.getMovieListValues()?.status == Status.LOADING },
            loadMore = { viewModel.postRecentMoviePage(it) },
            onLast = { false }
    ).run {
        currentPage = 1
    }
}

