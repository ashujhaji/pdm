package com.pixerapps.placie.ui.activity.user.home.fragments.feed

import android.view.View
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.PostPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedPresenter : BaseMvpPresenterImpl<FeedContract.View>(), FeedContract.Presenter {

    override fun loadPostFromServer(view: View) {
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .getAllPosts(
                    MyPref.getString(Constants.USER_TOKEN, "")
                )
            call.enqueue(object : Callback<PostPojo> {
                override fun onResponse(call: Call<PostPojo>, response: Response<PostPojo>) {
                    if (response.isSuccessful && response.body()!!.success) {
                        mView!!.showPosts(response.body()!!.data,view)
                    } else mView!!.showNoPost()
                }

                override fun onFailure(call: Call<PostPojo>, t: Throwable) {

                }
            })
        }
    }
}