package com.pixerapps.placie.ui.activity.authentication

import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.activity.authentication.fragments.common.CommonFragment
import com.pixerapps.placie.utils.Config

class AuthActivity : BaseMvpActivity<AuthActivityContract.View, AuthActivityPresenter>(), AuthActivityContract.View,
    View.OnClickListener {

    override var presenter: AuthActivityPresenter = AuthActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        showCommonFragment()
    }

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

    override fun showCommonFragment() {
        Config.setFragment(CommonFragment(), this, "auth_common_frag")
    }

    override fun showStudentFragment() {

    }

    override fun showAdminFragment() {

    }
}
