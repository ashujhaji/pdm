package com.pixerapps.placie.ui.activity.user.home

import android.os.Bundle
import android.os.PersistableBundle
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class HomeActivity : BaseMvpActivity<HomeActivityContract.View,HomeActivityPresenter>(),HomeActivityContract.View {
    override var presenter: HomeActivityPresenter= HomeActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_user_home)
    }
}