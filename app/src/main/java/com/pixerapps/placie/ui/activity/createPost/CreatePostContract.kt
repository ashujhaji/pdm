package com.pixerapps.placie.ui.activity.createPost

import android.app.Activity
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object CreatePostContract {
    interface View : BaseMvpView {
        fun setToolbar()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun createPost(activity: Activity,title : String, body : String, imageUrl : String, isJobPost : Boolean)
    }
}