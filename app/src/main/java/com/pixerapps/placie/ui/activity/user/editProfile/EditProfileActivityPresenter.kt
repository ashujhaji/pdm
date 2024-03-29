package com.pixerapps.placie.ui.activity.user.editProfile

import android.app.Activity
import android.app.ProgressDialog
import android.util.Log
import android.widget.Toast
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.UserPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EditProfileActivityPresenter : BaseMvpPresenterImpl<EditProfileActivityContract.View>(),
    EditProfileActivityContract.Presenter {

    private lateinit var progressDialog: ProgressDialog
    override fun updateUserProfile(
        activity: Activity,
        name: String,
        email: String,
        location: String,
        instId: String,
        course: String,
        startYear: String,
        endYear: String,
        bio: String
    ) {
        if (ApiClient.getClient() != null) {
            showProgressDialog("Profile updating", activity)
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .updateUserDetails(
                    MyPref.getString(Constants.USER_GID, ""),
                    MyPref.getString(Constants.USER_TOKEN, ""),
                    name, bio, email, instId, course, "$startYear-$endYear", getUserType(endYear), location
                )
            call.enqueue(object : Callback<UserPojo> {
                override fun onResponse(call: Call<UserPojo>, response: Response<UserPojo>) {
                    if (response.isSuccessful && response.body()!!.success) {
                        CurrentUserData.getInstance().getUserDetails {
                            Constants.USER_DETAILS = it.data[0]
                            progressDialog.dismiss()
                            Toast.makeText(activity, "Updated successfully", Toast.LENGTH_LONG).show()
                            activity.finish()
                        }
                    } else
                        Log.d("authstatus", response.message())
                }

                override fun onFailure(call: Call<UserPojo>, t: Throwable) {
                    Log.d("authstatus", t.message)
                }
            })
        }
    }


    private fun getUserType(endYear: String): String =
        if (Calendar.getInstance().get(Calendar.YEAR) > endYear.toInt()) {
            "Alumni"
        } else "Student"

    private fun showProgressDialog(message: String, activity: Activity) {
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage(message)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()
    }

}