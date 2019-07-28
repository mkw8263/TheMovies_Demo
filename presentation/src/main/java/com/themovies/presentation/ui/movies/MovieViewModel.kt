package com.themovies.presentation.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.themovies.domain.usecase.MovieUseCase
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.presentation.BaseViewModel
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : BaseViewModel() {
    sealed class Result {
        data class AdapterOnClick(val domainEntityMovie: DomainEntityMovie) : Result()
    }

    private val _liveResult = MutableLiveData<Result>()
    val liveResult: LiveData<Result> = _liveResult

    private val _liveLoading = MutableLiveData<Boolean>()
    val liveLoading: LiveData<Boolean> = _liveLoading

    private val _liveMovies = MutableLiveData<List<DomainEntityMovie>>()
    val liveMovies: LiveData<List<DomainEntityMovie>> = _liveMovies

    init {
        getMovies()
    }

    fun adapterOnclick(domainEntityMovie: DomainEntityMovie) {
        _liveResult.value = Result.AdapterOnClick(domainEntityMovie)
    }

    private fun getMovies() {
        _liveLoading.value = true
        movieUseCase.execute(MovieUseCase.Params(550))
            .subscribe { response, error ->
                _liveLoading.postValue(false)
                if (error != null) {

                } else {
                    _liveMovies.value = response
                }
            }.addTo(compositeDisposable)
    }
}