package com.pixerapps.placie.ui.activity.authentication.fragments.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment

class CommonFragment : BaseMvpFragment<CommonFragmentContract.View,CommonFragmentPresenter>(),CommonFragmentContract.View {
    override var presenter: CommonFragmentPresenter = CommonFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_common,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity,"Common fragment",Toast.LENGTH_LONG).show()
    }

}