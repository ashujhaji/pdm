package com.pixerapps.placie.ui.activity.post

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class PostFullActivity : BaseMvpActivity<PostFullContract.View, PostFullPresenter>(),PostFullContract.View {
    override var presenter: PostFullPresenter= PostFullPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_post)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE


    }
}