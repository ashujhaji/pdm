package com.pixerapps.placie.ui.activity.applicants

import com.pixerapps.placie.model.JobData
import com.pixerapps.placie.mvp.BaseMvpPresenter
import com.pixerapps.placie.mvp.BaseMvpView

object ApplicantContract {
    interface View : BaseMvpView {
        fun showToolbar()
        fun showData(applicants:JobData)
        fun showToast(message :String)
    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}