package com.pixerapps.placie.mvp

interface BaseMvpPresenter<in V: BaseMvpView> {
    fun attachView(view : V)
    fun detachView()
}