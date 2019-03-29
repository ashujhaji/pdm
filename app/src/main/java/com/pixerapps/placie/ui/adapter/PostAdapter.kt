package com.pixerapps.placie.ui.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pixerapps.placie.R
import com.pixerapps.placie.model.PostData

class PostAdapter(var list: List<PostData>, var activity: FragmentActivity) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.layout_post, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: PostAdapter.ViewHolder, pos: Int) {
        viewHolder.bindData(list[pos], pos)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var currentPos: Int = 0


        var user_dp: ImageView = itemView.findViewById(R.id.user_dp)
        var user_name: TextView = itemView.findViewById(R.id.user_name)
        var institution: TextView = itemView.findViewById(R.id.institution)
        var posted_at: TextView = itemView.findViewById(R.id.posted_at)
        var post_title: TextView = itemView.findViewById(R.id.post_title)
        var post_body: TextView = itemView.findViewById(R.id.post_body)
        var post_image: TextView = itemView.findViewById(R.id.post_image)
        var comment_count: TextView = itemView.findViewById(R.id.comment_count)
        var apply_btn: TextView = itemView.findViewById(R.id.apply_btn)
        var comment_box: TextView = itemView.findViewById(R.id.comment_box)

        fun bindData(data: PostData, pos: Int) {
            this.currentPos = pos

            user_name.text = data.contributorName
            institution.text = data.contributorInstitute
            posted_at.text = data.createdAt
            post_title.text = data.postTitle
            post_body.text = data.postBody
            comment_count.text = data.comments.size.toString() + " comments"
            if (data.isJobPost.contentEquals("true")) {
                apply_btn.visibility = View.VISIBLE
                apply_btn.setOnClickListener(this)
            }

            comment_box.setOnClickListener(this)
            comment_count.setOnClickListener(this)
            apply_btn.setOnClickListener(this)
            post_body.setOnClickListener(this)

        }


        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.apply_btn -> {

                }

                R.id.comment_box -> {

                }

                R.id.post_body -> {

                }

                R.id.comment_count -> {

                }
            }
        }
    }
}