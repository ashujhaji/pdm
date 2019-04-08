package com.pixerapps.placie.ui.activity.admin.main.fragment.feed

import android.view.View
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.JobPojo
import com.pixerapps.placie.model.PostPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminFeedPresenter : BaseMvpPresenterImpl<AdminFeedContract.View>(), AdminFeedContract.Presenter {

    override fun loadPostFromServer(view: View) {
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .getJobsByInstitute(Constants.ADMIN_DETAILS.centerCode,Constants.ADMIN_DETAILS.token)
            call.enqueue(object : Callback<JobPojo> {
                override fun onResponse(call: Call<JobPojo>, response: Response<JobPojo>) {
                    if (response.isSuccessful && response.body()!!.success) {
                        mView!!.showPosts(response.body()!!.data,view)
                    } else mView!!.showNoPost()
                }

                override fun onFailure(call: Call<JobPojo>, t: Throwable) {

                }
            })
        }
    }
}