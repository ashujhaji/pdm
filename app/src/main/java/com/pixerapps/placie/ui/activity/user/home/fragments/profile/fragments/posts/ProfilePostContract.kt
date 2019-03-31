package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.posts

import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object ProfilePostContract {
    interface View : BaseMvpView {
        fun showData(postData  : List<PostData>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadDataFromServer()
    }
}