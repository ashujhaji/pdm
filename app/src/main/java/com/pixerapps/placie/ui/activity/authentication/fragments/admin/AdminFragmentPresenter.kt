package com.pixerapps.placie.ui.activity.authentication.fragments.admin

import com.pixerapps.placie.mvp.BaseMvpPresenterImpl

class AdminFragmentPresenter : BaseMvpPresenterImpl<AdminFragmentContract.View>(), AdminFragmentContract.Presenter {
    override fun login(username: String, password: String) {
        if (username.isEmpty()){
            mView?.showAlert("Username is empty")
            return
        }else if (password.isEmpty()){
            mView?.showAlert("Password is empty")
            return
        }else{
            mView?.showProgress()
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
        }
    }
}