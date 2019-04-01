package com.pixerapps.placie.ui.activity.authentication.fragments.admin

import android.content.Intent
import android.support.v4.app.FragmentActivity
import com.pixerapps.placie.data.remote.api.ApiClient
import com.pixerapps.placie.data.remote.api.ApiInterface
import com.pixerapps.placie.model.AdminPojo
import com.pixerapps.placie.mvp.BaseMvpPresenterImpl
import com.pixerapps.placie.ui.activity.admin.main.MainActivity
import com.pixerapps.placie.utils.Constants
import com.pixerapps.placie.utils.MyPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminFragmentPresenter : BaseMvpPresenterImpl<AdminFragmentContract.View>(), AdminFragmentContract.Presenter {
    override fun login(activity: FragmentActivity, username: String, password: String) {
        if (username.isEmpty()){
            mView?.showAlert("Username is empty")
            return
        }else if (password.isEmpty()){
            mView?.showAlert("Password is empty")
            return
        }else{
            mView?.showProgress()
            if (ApiClient.getClient() != null) {
                val call = ApiClient.getClient().create(ApiInterface::class.java)
                    .loginAdmin(username,password)
                call.enqueue(object : Callback<AdminPojo> {
                    override fun onResponse(call: Call<AdminPojo>, response: Response<AdminPojo>) {
                        if (response.isSuccessful && response.body()!!.success) {
                            mView?.hideProgress()
                            mView?.showAlert("Successfully Logged in!")
                            MyPref.putBoolean(Constants.IS_ADMIN_LOGGED_IN,true)
                            MyPref.putString(Constants.USER_TOKEN,response.body()!!.data[0].token)
                            MyPref.putString(Constants.ADMIN_ID,response.body()!!.data[0].centerCode)
                            activity.startActivity(Intent(activity,MainActivity::class.java))
                        }else mView?.showAlert("Login failed")
                    }

                    override fun onFailure(call: Call<AdminPojo>, t: Throwable) {
                        mView?.showAlert("Login failed")
                    }
                })
            }
        }
    }

    override fun register(name: String, username: String, password: String) {
        if (name.isEmpty()){
            mView?.showAlert("Name is empty")
            return
        }else if (username.isEmpty()){
            mView?.showAlert("Username is empty")
            return
        }else if(password.isEmpty()){
            mView?.showAlert("Password is empty")
            return
        }else{
            mView?.showProgress()
            if (ApiClient.getClient() != null) {
                val call = ApiClient.getClient().create(ApiInterface::class.java)
                    .registerAsAdmin(username,password,name)
                call.enqueue(object : Callback<AdminPojo> {
                    override fun onResponse(call: Call<AdminPojo>, response: Response<AdminPojo>) {
                        if (response.isSuccessful && response.body()!!.success) {
                            mView?.hideProgress()
                            mView?.showAlert("Successfully Registered, Kindly login!")
                        }else mView?.showAlert(response.body()!!.message)
                    }

                    override fun onFailure(call: Call<AdminPojo>, t: Throwable) {
                        mView?.showAlert("Registration failed")
                    }
                })
            }
        }
    }
}