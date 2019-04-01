package com.pixerapps.placie.ui.activity.authentication.fragments.admin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_auth_admin.*

class AdminFragment : BaseMvpFragment<AdminFragmentContract.View, AdminFragmentPresenter>(), AdminFragmentContract.View,
    View.OnClickListener {

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override var presenter: AdminFragmentPresenter = AdminFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        login.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun showAlert(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login->{
                presenter.login(loginUname.text.toString(),loginPwd.text.toString())
            }

            R.id.register->{
                presenter.register(registerName.text.toString(),registerUname.text.toString(),registerPwd.text.toString())
            }
        }
    }

}