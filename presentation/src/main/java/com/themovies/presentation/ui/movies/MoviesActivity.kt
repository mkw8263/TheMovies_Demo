package com.themovies.presentation.ui.movies

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.themovies.common.createViewModel
import com.themovies.common.ob
import com.themovies.common.sceneTransitionAnimation
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.presentation.BaseActivity
import com.themovies.presentation.R
import com.themovies.presentation.databinding.ActivityMovieBinding
import com.themovies.presentation.ui.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_movie.*
import javax.inject.Inject


class MoviesActivity : BaseActivity<ActivityMovieBinding>() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MovieViewModel by lazy {
        createViewModel(factory, MovieViewModel::class.java)
    }
    override val layoutResource: Int
        get() = R.layout.activity_movie

    override fun setupViewDataBinding() {
        viewDataBinding.apply {
            movieViewModel = viewModel
            lifecycleOwner = this@MoviesActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ob(viewModel.liveResult, ::result)
    }

    private fun result(result: MovieViewModel.Result) {
        when (result) {
            is MovieViewModel.Result.AdapterOnClick -> startMovieDetailActivity(result.domainEntityMovie)
        }
    }

    private fun startMovieDetailActivity(domainEntityMovie: DomainEntityMovie) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra(MovieDetailActivity.EXTRA_MOVIE_DATA, domainEntityMovie)
        }

        startActivity(intent, sceneTransitionAnimation(rv_movies).toBundle())
    }
}
