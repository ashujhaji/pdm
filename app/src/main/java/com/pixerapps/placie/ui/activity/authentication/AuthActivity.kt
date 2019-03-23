package com.pixerapps.placie.ui.activity.authentication

import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class AuthActivity : BaseMvpActivity<AuthActivityContract.View, AuthActivityPresenter>(), AuthActivityContract.View,
    View.OnClickListener {

    override var presenter: AuthActivityPresenter = AuthActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

    override fun showCommonFragment() {

    }

    override fun showStudentFragment() {

    }

    override fun showAdminFragment() {

    }
}
