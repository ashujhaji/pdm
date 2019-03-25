package com.pixerapps.placie.ui.activity.user.home

import android.support.v4.app.Fragment
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object HomeActivityContract {
    interface View : BaseMvpView {

    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}