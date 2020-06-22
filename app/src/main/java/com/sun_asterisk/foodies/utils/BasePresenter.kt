package com.sun_asterisk.foodies.utils

interface BasePresenter<T> {
    fun onStart()
    fun setView(view: T?)
}
