package com.pixerapps.placie.ui.activity.post

import android.app.Activity
import android.app.ProgressDialog
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.ApplyResponseModel
import com.pixerapps.placie.model.PostPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFullPresenter : BaseMvpPresenterImpl<PostFullContract.View>(), PostFullContract.Presenter {

    private var dialog: ProgressDialog? = null

    override fun applyForJob(postId: String, activity: Activity) {
        showProgressDialog("Applying for this job",activity)
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .applyForJob(
                    MyPref.getString(Constants.USER_TOKEN, ""),
                    Constants.USER_DETAILS.user_gid,
                    Constants.USER_DETAILS.user_name,
                    Constants.USER_DETAILS.user_email,
                    postId
                )
            call.enqueue(object : Callback<ApplyResponseModel> {
                override fun onResponse(call: Call<ApplyResponseModel>, response: Response<ApplyResponseModel>) {
                    if (response.isSuccessful) {
                        mView?.showToast(response.body()!!.message)
                    } else mView?.showToast("Error occured")
                    dialog?.dismiss()
                }

                override fun onFailure(call: Call<ApplyResponseModel>, t: Throwable) {

                }
            })
        }
    }

    override fun addComment(postId: String, commentBody: String) {
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .addComment(MyPref.getString(Constants.USER_TOKEN, ""),
                    postId,commentBody,Constants.USER_DETAILS.user_name)
            call.enqueue(object : Callback<PostPojo> {
                override fun onResponse(call: Call<PostPojo>, response: Response<PostPojo>) {
                    if (response.isSuccessful&&response.body()!!.success) {
                        mView!!.refreshActivity()
                    } else mView!!.showToast("Error occured")
                }

                override fun onFailure(call: Call<PostPojo>, t: Throwable) {

                }
            })
        }
    }

    private fun showProgressDialog(message: String, activity: Activity) {
        dialog = ProgressDialog(activity)
        dialog!!.setMessage(message)
        dialog!!.show()
    }
}