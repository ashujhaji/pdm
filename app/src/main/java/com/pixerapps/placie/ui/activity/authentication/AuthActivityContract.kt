package com.pixerapps.placie.ui.activity.authentication

import android.support.v4.app.Fragment
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object AuthActivityContract {
    interface View : BaseMvpView {
        fun showCommonFragment()
        fun showStudentFragment()
        fun showAdminFragment()
    }

    interface Presenter : BaseMvpPresenter<View>{
        fun loadFragment(fragment: Fragment, fragName : String)
    }
}