package com.pixerapps.placie.ui.activity.user.home.fragments.feed

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.createPost.CreatePostActivity
import com.pixerapps.placie.ui.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_user_feed.*
import kotlinx.android.synthetic.main.fragment_user_feed.view.*

class FeedFragment : BaseMvpFragment<FeedContract.View, FeedPresenter>(), FeedContract.View, View.OnClickListener {
    override var presenter: FeedPresenter = FeedPresenter()
    var adapter: PostAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        return inflater.inflate(R.layout.fragment_user_feed, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadPostFromServer(view)

        add_post.setOnClickListener(this)
    }

    override fun showPosts(postData: List<PostData>, view: View) {
        adapter = PostAdapter(postData, activity!!)
        val linearLayoutManager = LinearLayoutManager(activity)
        view.data_recyclerview.layoutManager = linearLayoutManager
        view.data_recyclerview.adapter = adapter


    }

    override fun showNoPost() {
        Toast.makeText(activity, "No Post Found", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add_post -> {
                activity!!.startActivity(Intent(activity, CreatePostActivity::class.java))
            }
        }
    }
}