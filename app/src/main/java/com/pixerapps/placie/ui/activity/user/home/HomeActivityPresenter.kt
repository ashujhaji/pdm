package com.pixerapps.placie.ui.activity.user.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl

class HomeActivityPresenter : BaseMvpPresenterImpl<HomeActivityContract.View>(), HomeActivityContract.Presenter {
    override fun loadFragment(fragment: Fragment, fragmentActivity: FragmentActivity, fragName: String) {
        if (fragmentActivity.supportFragmentManager.findFragmentByTag(fragName) == null) {
            val fragmentManager = fragmentActivity.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.userHomeFrame, fragment, fragName)
            fragmentTransaction.commit()
        }
    }

}