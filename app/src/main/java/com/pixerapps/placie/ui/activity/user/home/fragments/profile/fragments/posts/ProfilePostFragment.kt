package com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.posts

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.model.PostData
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.createPost.CreatePostActivity
import com.pixerapps.placie.ui.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_profile_post.*
import kotlinx.android.synthetic.main.fragment_user_feed.view.*

class ProfilePostFragment : BaseMvpFragment<ProfilePostContract.View, ProfilePostPresenter>(),
    ProfilePostContract.View, View.OnClickListener {
    override var presenter: ProfilePostPresenter = ProfilePostPresenter()
    var adapter: PostAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadDataFromServer()

        no_item.setOnClickListener(this)
    }

    override fun showData(postData: List<PostData>) {
        no_item.visibility = View.GONE

        adapter = PostAdapter(postData, activity!!)
        val linearLayoutManager = LinearLayoutManager(activity)
        view!!.data_recyclerview.layoutManager = linearLayoutManager
        view!!.data_recyclerview.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.no_item -> {
                activity!!.startActivity(Intent(activity, CreatePostActivity::class.java))
            }
        }
    }
}