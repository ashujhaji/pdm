package com.pixerapps.placie.ui.activity.authentication

import android.support.v4.app.Fragment
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl

class AuthActivityPresenter : BaseMvpPresenterImpl<AuthActivityContract.View>(),AuthActivityContract.Presenter{
    override fun loadFragment(fragment: Fragment, fragName: String) {

    }

}