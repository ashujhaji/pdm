package com.pixerapps.placie.ui.activity.post

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.helper.ImageHelper
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.adapter.CommentAdapter
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.activity_full_post.*

class PostFullActivity(postData: PostData) : BaseMvpActivity<PostFullContract.View, PostFullPresenter>(),
    PostFullContract.View, View.OnClickListener {

    override var presenter: PostFullPresenter = PostFullPresenter()
    var adapter: CommentAdapter? = null
    var post: PostData = postData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_post)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        showData(post)

    }

    override fun showData(post: PostData) {
        ImageHelper.loadImageWithBlurEffect(this, post_image, post.image)
        user_name.text = post.contributorName
        institution.text = post.contributorInstitute
        posted_at.text = post.createdAt.substring(0, 10)
        post_title.text = post.postTitle
        post_body.text = post.postBody
        comment_count.text = post.comments.size.toString() + " comments"
        if (post.isJobPost && post.contributorId == Constants.USER_DETAILS.instituteId) {
            apply_btn.visibility = View.VISIBLE
            apply_btn.setOnClickListener(this)
        }

        adapter = CommentAdapter(post.comments, this)
        val linearLayoutManager = LinearLayoutManager(this)
        comment_recycler.layoutManager = linearLayoutManager
        comment_recycler.adapter = adapter


    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.apply_btn -> {

            }
        }
    }
}