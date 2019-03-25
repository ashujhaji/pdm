package com.pixerapps.placie.ui.activity.user.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class HomeActivity : BaseMvpActivity<HomeActivityContract.View,HomeActivityPresenter>(),HomeActivityContract.View {
    override var presenter: HomeActivityPresenter= HomeActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE
    }
}