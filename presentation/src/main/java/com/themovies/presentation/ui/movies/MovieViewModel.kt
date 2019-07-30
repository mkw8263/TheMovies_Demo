package com.themovies.presentation.ui.movies

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.domain.usecase.MovieUseCase
import com.themovies.presentation.BaseViewModel
import com.themovies.presentation.R
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : BaseViewModel() {
    sealed class State {
        data class ErrorMessage(@StringRes val msg: Int) : State()
        data class AdapterOnClick(val domainEntityMovie: DomainEntityMovie) : State()
    }

    private val _liveResult = MutableLiveData<State>()
    val liveResult: LiveData<State> = _liveResult

    private val _liveLoading = MutableLiveData<Boolean>()
    val liveLoading: LiveData<Boolean> = _liveLoading

    private val _liveMovies = MutableLiveData<List<DomainEntityMovie>>()
    val liveMovies: LiveData<List<DomainEntityMovie>> = _liveMovies

    init {
        getMovies()
    }

    fun adapterOnclick(domainEntityMovie: DomainEntityMovie) {
        _liveResult.value = State.AdapterOnClick(domainEntityMovie)
    }

    private fun getMovies() {
        _liveLoading.value = true
        movieUseCase.execute(MovieUseCase.Params(550))
            .subscribe { response, error ->
                _liveLoading.postValue(false)
                if (error != null) {
                    _liveResult.value = State.ErrorMessage(R.string.network_error)
                } else {
                    _liveMovies.value = response
                }
            }.addTo(compositeDisposable)
    }
}
