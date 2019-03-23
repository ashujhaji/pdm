package com.pixerapps.placie.ui.activity.authentication.fragments.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.utils.Config
import kotlinx.android.synthetic.main.fragment_auth_common.*

class StudentFragment : BaseMvpFragment<StudentFragmentContract.View,StudentFragmentPresenter>(),StudentFragmentContract.View,
View.OnClickListener{
    override var presenter: StudentFragmentPresenter = StudentFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_student,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context,"set",Toast.LENGTH_LONG).show()

    }

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

}