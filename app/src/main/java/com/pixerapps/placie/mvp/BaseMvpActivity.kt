package com.pixerapps.placie.mvp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseMvpActivity<in V: BaseMvpView, T: BaseMvpPresenter<V>> : AppCompatActivity(),BaseMvpView{

    protected abstract var presenter: T

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter.attachView(this as V)
    }

    override fun getContext(): Context = this

    override fun showError(error: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(stringResId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(stringResId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}