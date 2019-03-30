package com.pixerapps.placie.ui.activity.createPost

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_create_post.*
import kotlinx.android.synthetic.main.activity_full_post.*

class CreatePostActivity : BaseMvpActivity<CreatePostContract.View, CreatePostPresenter>(),
    CreatePostContract.View, View.OnClickListener {

    override var presenter: CreatePostPresenter = CreatePostPresenter()
    var postTitle: EditText? = null
    var postBody: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        postTitle = findViewById(R.id.post_title)
        postBody = findViewById(R.id.post_body)

        create_post.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.create_post -> {
                if (postBody!!.text.length>3){
                    presenter.createPost(
                        this,
                        postTitle!!.text.toString(),
                        postBody!!.text.toString(),
                        "",
                        false
                    )
                }else Toast.makeText(this,"Please write something useful",Toast.LENGTH_LONG).show()
            }
        }
    }
}