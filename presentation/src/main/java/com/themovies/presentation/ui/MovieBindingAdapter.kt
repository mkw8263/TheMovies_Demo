package com.themovies.presentation.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.presentation.R
import com.themovies.presentation.ui.movies.MovieViewModel
import com.themovies.presentation.ui.movies.adapter.DividerItemDecoration
import com.themovies.presentation.ui.movies.adapter.MovieAdapter

@BindingAdapter(value = ["movies", "viewModel"])
fun RecyclerView.setupMovies(items: List<DomainEntityMovie>?, vm: MovieViewModel) {
    this.adapter?.let {
        if (it is MovieAdapter) it.setupList(items)
    } ?: run {
        PagerSnapHelper().attachToRecyclerView(this)
        addItemDecoration(DividerItemDecoration(20))
        MovieAdapter(vm, Glide.with(context)).apply {
            this@setupMovies.adapter = this
            setupList(items)
        }
    }
}

@BindingAdapter(value = ["img", "requestManager"])
fun ImageView.movieImage(path: String, manager: RequestManager) {
    manager.load(this.context.getString(R.string.image_base_url) + path)
        .placeholder(R.drawable.img_placeholder)
        .into(this)
}

@BindingAdapter(value = ["detailImage"])
fun ImageView.detailMovieImage(path: String) {
    Glide.with(this).load(this.context.getString(R.string.image_base_url) + path)
        .placeholder(R.drawable.img_placeholder)
        .into(this)
}