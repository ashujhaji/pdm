package com.pixerapps.placie.ui.activity.authentication.fragments.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class AdminFragment : BaseMvpFragment<AdminFragmentContract.View,AdminFragmentPresenter>(),AdminFragmentContract.View,
View.OnClickListener{
    override var presenter: AdminFragmentPresenter = AdminFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_admin,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

}