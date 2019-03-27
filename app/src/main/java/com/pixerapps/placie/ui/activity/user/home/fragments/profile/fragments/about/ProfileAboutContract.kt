package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.about

import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object ProfileAboutContract {
    interface View : BaseMvpView {
        fun showUserData()
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}