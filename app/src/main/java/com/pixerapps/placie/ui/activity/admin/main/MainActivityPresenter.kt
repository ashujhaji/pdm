package com.pixerapps.placie.ui.activity.admin.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl

class MainActivityPresenter : BaseMvpPresenterImpl<MainActivityContract.View>(), MainActivityContract.Presenter {
    override fun loadFragment(fragment: Fragment, fragmentActivity: FragmentActivity, fragName: String) {
        if (fragmentActivity.supportFragmentManager.findFragmentByTag(fragName) == null) {
            val fragmentManager = fragmentActivity.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.adminrHomeFrame, fragment, fragName)
            fragmentTransaction.commit()
        }
    }
}