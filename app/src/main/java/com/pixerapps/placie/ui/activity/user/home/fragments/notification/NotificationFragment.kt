package com.pixerapps.placie.ui.activity.user.home.fragments.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class NotificationFragment : BaseMvpFragment<NotificationContract.View,NotificationPresenter>(),NotificationContract.View {
    override var presenter: NotificationPresenter= NotificationPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_notification,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}