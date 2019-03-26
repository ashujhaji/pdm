package com.pixerapps.placie.ui.activity.user.home.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class ProfileFragment : BaseMvpFragment<ProfileContract.View,ProfilePresenter>(),ProfileContract.View {
    override var presenter: ProfilePresenter= ProfilePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_profile,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}