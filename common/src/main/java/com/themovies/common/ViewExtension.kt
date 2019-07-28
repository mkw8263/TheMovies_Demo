package com.themovies.common

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat

fun ViewGroup.recyclerViewInflate(@LayoutRes layout: Int, attach: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layout, this, attach)
}

fun Activity.sceneTransitionAnimation(targetView: View): ActivityOptionsCompat {
    return ActivityOptionsCompat.makeSceneTransitionAnimation(
        this,
        targetView,
        ViewCompat.getTransitionName(targetView).orEmpty()
    )
}