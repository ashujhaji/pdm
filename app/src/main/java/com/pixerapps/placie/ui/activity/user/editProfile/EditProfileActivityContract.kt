package com.pixerapps.placie.ui.activity.user.editProfile

import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object EditProfileActivityContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun updateFieldsWithExistingData()
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}