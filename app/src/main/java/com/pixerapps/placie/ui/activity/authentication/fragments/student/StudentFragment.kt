package com.pixerapps.placie.ui.activity.authentication.fragments.student

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.PermanentAuth
import com.pixerapps.placie.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_auth_student.*

class StudentFragment : BaseMvpFragment<StudentFragmentContract.View, StudentFragmentPresenter>(),
    StudentFragmentContract.View,
    View.OnClickListener {
    override var presenter: StudentFragmentPresenter = StudentFragmentPresenter()
    private val RC_SIGN_IN_GOOGLE = 2

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
                FirebaseAuth.getInstance().signOut()
                val signInIntent = Auth.GoogleSignInApi.getSignInIntent(
                    PermanentAuth.getInstance().getGoogleApiClient(
                        activity
                    )
                )
                startActivityForResult(signInIntent, RC_SIGN_IN_GOOGLE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN_GOOGLE) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            Log.d("TAG", "handleSignInResult:" + result.status.isSuccess)
            if (result.isSuccess) {
                val account = result.signInAccount
                PermanentAuth.getInstance().permanentAuthenticate(activity, account)
            } else
                Toast.makeText(activity, "Something wrong here", Toast.LENGTH_SHORT).show()
        }
    }

}