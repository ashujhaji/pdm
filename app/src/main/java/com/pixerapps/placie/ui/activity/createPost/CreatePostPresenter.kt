package com.pixerapps.placie.ui.activity.createPost

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.PostPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.ui.activity.user.home.HomeActivity
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CreatePostPresenter : BaseMvpPresenterImpl<CreatePostContract.View>(), CreatePostContract.Presenter {

    private var dialog: ProgressDialog? = null

    override fun createPost(activity: Activity, title: String, body: String, imageUrl: Uri, isJobPost: Boolean) {
        showProgressDialog("Posting...", activity)
        if (imageUrl.toString().length > 1) {
            val storage = FirebaseStorage.getInstance().reference.child(
                "post_images/" + Calendar.getInstance().get(
                    Calendar.MILLISECOND
                )
            )
            storage.putFile(imageUrl).addOnCompleteListener {
                storage.downloadUrl.addOnSuccessListener {
                    if (ApiClient.getClient() != null) {
                        val call = ApiClient.getClient().create(ApiInterface::class.java)
                            .createPost(
                                MyPref.getString(Constants.USER_TOKEN, ""),
                                body, title, it.toString(),
                                Constants.USER_DETAILS.user_gid,
                                Constants.USER_DETAILS.user_name,
                                Constants.USER_DETAILS.college_name
                            )
                        call.enqueue(object : Callback<PostPojo> {
                            override fun onResponse(call: Call<PostPojo>, response: Response<PostPojo>) {
                                if (response.isSuccessful && response.body()!!.success) {
                                    dialog?.dismiss()
                                    Toast.makeText(activity, "Posted successfully", Toast.LENGTH_LONG).show()
                                    activity.startActivity(Intent(activity, HomeActivity::class.java))
                                } else {
                                    dialog?.dismiss()
                                    Toast.makeText(activity, "Error occurred", Toast.LENGTH_LONG).show()
                                }
                            }

                            override fun onFailure(call: Call<PostPojo>, t: Throwable) {

                            }
                        })
                    }
                }
            }
        } else {
            if (ApiClient.getClient() != null) {
                val call = ApiClient.getClient().create(ApiInterface::class.java)
                    .createPost(
                        MyPref.getString(Constants.USER_TOKEN, ""),
                        body, title, "",
                        Constants.USER_DETAILS.user_gid,
                        Constants.USER_DETAILS.user_name,
                        Constants.USER_DETAILS.college_name
                    )
                call.enqueue(object : Callback<PostPojo> {
                    override fun onResponse(call: Call<PostPojo>, response: Response<PostPojo>) {
                        if (response.isSuccessful && response.body()!!.success) {
                            dialog!!.dismiss()
                            Toast.makeText(activity, "Posted successfully", Toast.LENGTH_LONG).show()
                            activity.startActivity(Intent(activity, HomeActivity::class.java))
                        } else {
                            dialog!!.dismiss()
                            Toast.makeText(activity, "Error occurred", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<PostPojo>, t: Throwable) {

                    }
                })
            }
        }
    }

    private fun showProgressDialog(message: String, activity: Activity) {
        dialog = ProgressDialog(activity)
        dialog!!.setMessage(message)
        dialog!!.show()
    }

}