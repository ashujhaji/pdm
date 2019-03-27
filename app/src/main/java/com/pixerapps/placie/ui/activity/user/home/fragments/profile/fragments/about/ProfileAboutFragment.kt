package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_profile_about.*

class ProfileAboutFragment : BaseMvpFragment<ProfileAboutContract.View,ProfileAboutPresenter>(),ProfileAboutContract.View {
    override var presenter: ProfileAboutPresenter= ProfileAboutPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_about,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showUserData()
    }

    override fun showUserData() {
        if (CurrentUserData.getInstance().userData[0].user_email!=null){
            user_email.text = CurrentUserData.getInstance().userData[0].user_email
        }else {
            user_email.text = "Please update your email"
        }

        if (CurrentUserData.getInstance().userData[0].location!=null){
            user_location.text = CurrentUserData.getInstance().userData[0].location
        }else {
            user_location.text = "Please update your location"
        }

        if (CurrentUserData.getInstance().userData[0].user_email!=null){
            user_email.text = CurrentUserData.getInstance().userData[0].user_email
        }else {
            user_email.text = "Please update your email"
        }

        if (CurrentUserData.getInstance().userData[0].college_name!=null){
            user_college.text = CurrentUserData.getInstance().userData[0].college_name
        }else {
            user_college.text = "Please update your institution"
        }

        if (CurrentUserData.getInstance().userData[0].session!=null){
            user_session.text = CurrentUserData.getInstance().userData[0].session
        }else {
            user_session.text = "Please update your session"
        }

        if (CurrentUserData.getInstance().userData[0].user_email!=null){
            user_email.text = CurrentUserData.getInstance().userData[0].user_email
        }else {
            user_email.text = "Please update your email"
        }

        if (CurrentUserData.getInstance().userData[0].user_bio!=null){
            user_bio.text = CurrentUserData.getInstance().userData[0].user_bio
        }else {
            user_bio.text = "Please update your bio"
        }
    }
}