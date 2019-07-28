package com.themovies.presentation.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.themovies.presentation.databinding.ItemMovieBinding

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding: ItemMovieBinding = ItemMovieBinding.bind(view)
}