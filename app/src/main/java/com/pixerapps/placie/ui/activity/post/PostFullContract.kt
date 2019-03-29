package com.pixerapps.placie.ui.activity.post

import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object PostFullContract {
    interface View : BaseMvpView {
        fun showData(post:PostData)
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}