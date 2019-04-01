package com.pixerapps.placie.ui.activity.authentication.fragments.admin

import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object AdminFragmentContract {
    interface View : BaseMvpView {
        fun showProgress()
        fun showAlert(message : String)
        fun hideProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun login(username : String, password : String)
        fun register(name : String, username: String, password: String)
    }
}