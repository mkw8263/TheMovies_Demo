package com.themovies.common

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

fun <T : ViewModel> AppCompatActivity.createViewModel(
    factory: ViewModelProvider.Factory, classType: Class<T>
): T = ViewModelProviders.of(this, factory)[classType]


fun <T> LifecycleOwner.ob(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}
