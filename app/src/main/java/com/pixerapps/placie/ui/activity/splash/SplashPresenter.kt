package com.pixerapps.placie.ui.activity.splash

import android.app.Activity
import android.content.Intent
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.AdminPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.ui.activity.admin.main.MainActivity
import com.pixerapps.placie.ui.activity.authentication.AuthActivity
import com.pixerapps.placie.ui.activity.user.home.HomeActivity
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashPresenter : BaseMvpPresenterImpl<SplashContract.View>(),SplashContract.Presenter {
    override fun moveToNextActivity(activity: Activity) {
        if (MyPref.getBoolean(Constants.IS_USER_LOGGED_IN,false)){
            loadUserData(activity)
        }else if(MyPref.getBoolean(Constants.IS_ADMIN_LOGGED_IN,false)){
            loadAdminData(activity)
        }
        else activity.startActivity(Intent(activity,AuthActivity::class.java))
    }

    override fun loadUserData(activity: Activity) {
        CurrentUserData.getInstance().getUserDetails {
            Constants.USER_DETAILS=it.data[0]
            activity.startActivity(Intent(activity,HomeActivity::class.java))
        }
    }

    override fun loadAdminData(activity: Activity) {
        if (ApiClient.getClient() != null) {
            val call = ApiClient.getClient().create(ApiInterface::class.java)
                .getAdminData(MyPref.getString(Constants.ADMIN_ID,""),
                    MyPref.getString(Constants.USER_TOKEN,""))
            call.enqueue(object : Callback<AdminPojo> {
                override fun onResponse(call: Call<AdminPojo>, response: Response<AdminPojo>) {
                    if (response.isSuccessful && response.body()!!.success) {
                        Constants.ADMIN_DETAILS = response.body()!!.data[0]
                        activity.startActivity(Intent(activity, MainActivity::class.java))
                    }
                }

                override fun onFailure(call: Call<AdminPojo>, t: Throwable) {
                }
            })
        }
    }
}