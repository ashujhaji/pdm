package com.pixerapps.placie.ui.activity.post

import android.app.Activity
import com.pixerapps.placie.model.Comments
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object PostFullContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun showData(post:PostData)
        fun showToast(message :String)
        fun refreshActivity()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun applyForJob(postId : String, activity: Activity)
        fun addComment(postId: String, commentBody: String)
    }
}