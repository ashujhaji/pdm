package com.pixerapps.placie.ui.activity.splash

import android.os.Bundle
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class SplashActivity : BaseMvpActivity<SplashContract.View, SplashPresenter>(),SplashContract.View {
    override var presenter: SplashPresenter= SplashPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.moveToNextActivity(this)
    }
}