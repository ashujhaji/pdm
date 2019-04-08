package com.pixerapps.placie.ui.activity.admin.main.fragment.feed

import com.pixerapps.placie.model.JobData
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView


object AdminFeedContract {
    interface View : BaseMvpView {
        fun showPosts(postData: List<JobData>, view:android.view.View)
        fun showNoPost()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadPostFromServer(view:android.view.View)
    }
}