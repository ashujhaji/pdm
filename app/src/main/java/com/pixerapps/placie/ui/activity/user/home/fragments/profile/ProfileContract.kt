package com.pixerapps.placie.ui.activity.user.home.fragments.profile

import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object ProfileContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun showUserDetails()
        fun showViepager()
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}