package com.pixerapps.placie.ui.activity.splash

import android.os.Bundle
import android.os.PersistableBundle
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class SplashActivity : BaseMvpActivity<SplashContract.View, SplashPresenter>(),SplashContract.View {
    override var presenter: SplashPresenter= SplashPresenter()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_splash)
    }
}