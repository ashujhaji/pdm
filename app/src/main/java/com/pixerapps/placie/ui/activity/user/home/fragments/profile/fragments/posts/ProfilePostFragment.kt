package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class ProfilePostFragment : BaseMvpFragment<ProfilePostContract.View,ProfilePostPresenter>(),ProfilePostContract.View {
    override var presenter: ProfilePostPresenter= ProfilePostPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_post,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}