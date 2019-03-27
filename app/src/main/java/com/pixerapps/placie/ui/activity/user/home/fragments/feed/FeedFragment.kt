package com.pixerapps.placie.ui.activity.user.home.fragments.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class FeedFragment : BaseMvpFragment<FeedContract.View,FeedPresenter>(),FeedContract.View {
    override var presenter: FeedPresenter= FeedPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        return inflater.inflate(R.layout.fragment_user_feed,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}