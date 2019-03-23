package com.pixerapps.placie.ui.activity.authentication.fragments.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.authentication.fragments.admin.AdminFragment
import com.pixerapps.placie.ui.activity.authentication.fragments.student.StudentFragment
import com.pixerapps.placie.utils.Config
import kotlinx.android.synthetic.main.fragment_auth_common.*

class CommonFragment : BaseMvpFragment<CommonFragmentContract.View,CommonFragmentPresenter>(),CommonFragmentContract.View,
View.OnClickListener{
    override var presenter: CommonFragmentPresenter = CommonFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_common,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentAuth.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.studentAuth->{
                Config.setFragment(StudentFragment(), activity, "student_frag")
            }

            R.id.adminAuth->{
                Config.setFragment(AdminFragment(), activity, "admin_frag")
            }
        }
    }

}