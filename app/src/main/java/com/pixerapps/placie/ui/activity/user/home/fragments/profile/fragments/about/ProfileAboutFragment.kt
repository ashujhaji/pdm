package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class ProfileAboutFragment : BaseMvpFragment<ProfileAboutContract.View,ProfileAboutPresenter>(),ProfileAboutContract.View {
    override var presenter: ProfileAboutPresenter= ProfileAboutPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_about,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}