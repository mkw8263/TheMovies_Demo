package com.themovies.domain

import io.reactivex.Flowable

interface FlowableUseCase<Params, Type> : UseCase {
    fun execute(params: Params? = null): Flowable<Type>
}
