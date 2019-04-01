package com.pixerapps.placie.ui.activity.admin.main.fragment.profile

import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object AdminProfileContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun showUserDetails()
        fun showViepager()
        fun showLogoutDialog()
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}