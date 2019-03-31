package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.posts

import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.PostPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePostPresenter : BaseMvpPresenterImpl<ProfilePostContract.View>(),ProfilePostContract.Presenter {

    override fun loadDataFromServer() {
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .getPostByUser(
                    MyPref.getString(Constants.USER_TOKEN, ""),
                    Constants.USER_DETAILS.user_gid
                )
            call.enqueue(object : Callback<PostPojo> {
                override fun onResponse(call: Call<PostPojo>, response: Response<PostPojo>) {
                    if (response.isSuccessful && response.body()!!.success) {
                        mView!!.showData(response.body()!!.data)
                    }
                }

                override fun onFailure(call: Call<PostPojo>, t: Throwable) {

                }
            })
        }
    }
}