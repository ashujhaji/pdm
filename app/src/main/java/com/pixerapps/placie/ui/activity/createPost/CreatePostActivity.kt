package com.pixerapps.placie.ui.activity.createPost

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.helper.ImageHelper
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.activity.post.PostFullPresenter
import com.pixerapps.placie.ui.adapter.CommentAdapter
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.activity_full_post.*

class CreatePostActivity : BaseMvpActivity<CreatePostContract.View, CreatePostPresenter>(),
    CreatePostContract.View, View.OnClickListener {

    override var presenter: CreatePostPresenter = CreatePostPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE


    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.apply_btn -> {

            }
        }
    }
}