package com.pixerapps.placie.ui.activity.splash

import android.app.Activity
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object SplashContract {
    interface View : BaseMvpView {
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun moveToNextActivity(activity: Activity)
        fun loadUserData(activity: Activity)
        fun loadAdminData(activity: Activity)
    }
}