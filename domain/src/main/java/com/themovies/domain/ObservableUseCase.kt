package com.themovies.domain

import io.reactivex.Observable

interface ObservableUseCase<Params, Type> : UseCase {
    fun execute(params: Params? = null): Observable<Type>
}
