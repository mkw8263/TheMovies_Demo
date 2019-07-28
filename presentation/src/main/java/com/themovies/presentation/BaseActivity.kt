package com.themovies.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {
    abstract val layoutResource: Int
    lateinit var viewDataBinding: B


    abstract fun setupViewDataBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
        setupViewDataBinding()
    }
}