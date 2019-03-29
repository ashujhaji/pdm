package com.pixerapps.placie.ui.activity.splash

import android.app.Activity
import android.content.Intent
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.ui.activity.authentication.AuthActivity
import com.pixerapps.placie.ui.activity.user.home.HomeActivity
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref

class SplashPresenter : BaseMvpPresenterImpl<SplashContract.View>(),SplashContract.Presenter {
    override fun moveToNextActivity(activity: Activity) {
        if (MyPref.getBoolean(Constants.IS_USER_LOGGED_IN,false)){
            loadUserData(activity)
        }else activity.startActivity(Intent(activity,AuthActivity::class.java))
    }

    override fun loadUserData(activity: Activity) {
        CurrentUserData.getInstance().getUserDetails {
            Constants.USER_DETAILS=it.data[0]
            activity.startActivity(Intent(activity,HomeActivity::class.java))
        }
    }
}