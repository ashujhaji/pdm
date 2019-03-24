package com.pixerapps.placie.ui.activity.authentication

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.activity.authentication.fragments.common.CommonFragment
import com.pixerapps.placie.utils.Config

class AuthActivity : BaseMvpActivity<AuthActivityContract.View, AuthActivityPresenter>(), AuthActivityContract.View {

    override var presenter: AuthActivityPresenter = AuthActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_splash)

        showCommonFragment()
    }

    override fun showCommonFragment() {
        Config.setFragment(CommonFragment(), this, "auth_common_frag")
    }

    override fun showStudentFragment() {

    }

    override fun showAdminFragment() {

    }
}
