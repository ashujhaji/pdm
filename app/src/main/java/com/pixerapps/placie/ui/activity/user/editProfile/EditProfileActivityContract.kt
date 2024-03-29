package com.pixerapps.placie.ui.activity.user.editProfile

import android.app.Activity
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object EditProfileActivityContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun updateFieldsWithExistingData()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun updateUserProfile(activity: Activity, name:String, email:String, location:String, instId:String, course:String, startYear:String, endYear:String, bio:String)
    }
}