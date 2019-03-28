package com.pixerapps.placie.ui.activity.splash

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class SplashActivity : BaseMvpActivity<SplashContract.View, SplashPresenter>(),SplashContract.View {
    override var presenter: SplashPresenter= SplashPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        presenter.loadUserData(this)
    }
}