package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.user.editProfile.EditProfileActivity
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.fragment_profile_about.*

class ProfileAboutFragment : BaseMvpFragment<ProfileAboutContract.View, ProfileAboutPresenter>(),
    ProfileAboutContract.View{
    override var presenter: ProfileAboutPresenter = ProfileAboutPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showUserData()

        user_email.setOnClickListener {
            startActivity(Intent(activity, EditProfileActivity::class.java))
        }
    }

    override fun showUserData() {
        if (Constants.USER_DETAILS.user_email!=null) {
            user_email.text = Constants.USER_DETAILS.user_email
        } else {
            user_email.text = "Please update your email"
        }

        if (Constants.USER_DETAILS.location!=null) {
            user_location.text = Constants.USER_DETAILS.location
        } else {
            user_location.text = "Please update your location"
        }

        if (Constants.USER_DETAILS.user_email!=null) {
            user_email.text = Constants.USER_DETAILS.user_email
        } else {
            user_email.text = "Please update your email"
        }

        if (Constants.USER_DETAILS.college_name!=null) {
            user_college.text = Constants.USER_DETAILS.college_name
        } else {
            user_college.text = "Please update your institution"
        }

        if (Constants.USER_DETAILS.session!=null) {
            user_session.text = Constants.USER_DETAILS.session
        } else {
            user_session.text = "Please update your session"
        }

        if (Constants.USER_DETAILS.user_email!=null) {
            user_email.text = Constants.USER_DETAILS.user_email
        } else {
            user_email.text = "Please update your email"
        }

        if (Constants.USER_DETAILS.user_bio!=null) {
            user_bio.text = Constants.USER_DETAILS.user_bio
        } else {
            user_bio.text = "Please update your bio"
        }
    }

}