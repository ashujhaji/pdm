package com.pixerapps.placie.ui.activity.admin.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object MainActivityContract {
    interface View : BaseMvpView {
        fun showDefaultFragment()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadFragment(fragment:Fragment,fragmentActivity: FragmentActivity,fragName:String)
    }
}