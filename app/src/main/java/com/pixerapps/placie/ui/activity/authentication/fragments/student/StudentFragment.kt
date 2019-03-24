package com.pixerapps.placie.ui.activity.authentication.fragments.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_auth_student.*

class StudentFragment : BaseMvpFragment<StudentFragmentContract.View, StudentFragmentPresenter>(),
    StudentFragmentContract.View,
    View.OnClickListener {
    override var presenter: StudentFragmentPresenter = StudentFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        googleBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.googleBtn->{

            }
        }
    }

}