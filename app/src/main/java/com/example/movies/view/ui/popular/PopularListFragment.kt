package com.example.movies.view.ui.popular

import android.os.Bundle
import android.view.*
import com.example.movies.R
import com.example.movies.compose.ViewModelFragment
import com.example.movies.databinding.FragmentPopularBinding
import com.example.movies.view.adapter.MovieListAdapter

class PopularListFragment : ViewModelFragment() {

    private val viewModel: PopularViewModel by injectActivityVIewModels()
    lateinit var popularBinding: FragmentPopularBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        popularBinding = binding(inflater, R.layout.fragment_popular, container)
        return popularBinding.apply {
            viewModel = this@PopularListFragment.viewModel.apply { postPopularMoviePage(1) }
            lifecycleOwner = this@PopularListFragment
            adapter = MovieListAdapter()
        }.root
    }

}
