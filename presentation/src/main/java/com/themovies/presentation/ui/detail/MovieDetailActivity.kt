package com.themovies.presentation.ui.detail

import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.presentation.BaseActivity
import com.themovies.presentation.R
import com.themovies.presentation.databinding.ActivityMovieDetailBinding
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding>() {

    companion object {
        val EXTRA_MOVIE_DATA = MovieDetailActivity::class.java.name
    }

    override val layoutResource: Int
        get() = R.layout.activity_movie_detail

    override fun setupViewDataBinding() {
        Glide.with(this)
        viewDataBinding.apply {
            movie = intent.getParcelableExtra<DomainEntityMovie>(EXTRA_MOVIE_DATA)
            lifecycleOwner = this@MovieDetailActivity
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }
}
