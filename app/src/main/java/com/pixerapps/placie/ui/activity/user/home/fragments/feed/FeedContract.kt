package com.pixerapps.placie.ui.activity.user.home.fragments.feed

import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView


object FeedContract {
    interface View : BaseMvpView {
        fun showPosts(postData: List<PostData>, view:android.view.View)
        fun showNoPost()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadPostFromServer(view:android.view.View)
    }
}