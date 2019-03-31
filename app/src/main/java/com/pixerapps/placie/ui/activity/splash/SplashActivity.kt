package com.pixerapps.placie.ui.activity.splash

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class SplashActivity : BaseMvpActivity<SplashContract.View, SplashPresenter>(),SplashContract.View {
    override var presenter: SplashPresenter= SplashPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        presenter.moveToNextActivity(this)
    }
}