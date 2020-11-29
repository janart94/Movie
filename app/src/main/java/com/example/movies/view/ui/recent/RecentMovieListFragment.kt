package com.example.movies.view.ui.recent

import android.os.Bundle
import android.view.*
import com.example.movies.R
import com.example.movies.compose.ViewModelFragment
import com.example.movies.databinding.RecentFragmentMovieBinding
import com.example.movies.view.adapter.RecentListAdapter

class RecentMovieListFragment : ViewModelFragment() {
    private val viewModel: RecentViewModel by injectActivityVIewModels()
    lateinit var recentFragmentMovieBinding: RecentFragmentMovieBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        recentFragmentMovieBinding = binding(inflater, R.layout.recent_fragment_movie, container)
        return recentFragmentMovieBinding.apply {
            viewModel = this@RecentMovieListFragment.viewModel.apply { postRecentMoviePage(1) }
            lifecycleOwner = this@RecentMovieListFragment
            adapter = RecentListAdapter()
        }.root
    }
}
