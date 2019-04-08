package com.pixerapps.placie.ui.adapter

import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pixerapps.placie.R
import com.pixerapps.placie.helper.ImageHelper
import com.pixerapps.placie.model.JobData
import com.pixerapps.placie.ui.activity.post.PostFullActivity
import com.pixerapps.placie.utils.Constants
import java.io.Serializable

class JobAdapter(var list: List<JobData>, var activity: FragmentActivity) :
    RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): JobAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.layout_job, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        viewHolder.bindData(list[p1], p1, activity)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var currentPos: Int = 0
        lateinit var activity: FragmentActivity
        lateinit var post: JobData


        var user_dp: ImageView = itemView.findViewById(R.id.user_dp)
        var user_name: TextView = itemView.findViewById(R.id.user_name)
        var posted_at: TextView = itemView.findViewById(R.id.posted_at)
        var post_title: TextView = itemView.findViewById(R.id.post_title)
        var post_body: TextView = itemView.findViewById(R.id.post_body)
        var post_image: ImageView = itemView.findViewById(R.id.post_image)
        var comment_count: TextView = itemView.findViewById(R.id.comment_count)
        var apply_btn: TextView = itemView.findViewById(R.id.apply_btn)

        fun bindData(data: JobData, pos: Int, activity: FragmentActivity) {
            this.currentPos = pos
            this.activity = activity
            this.post = data

            user_name.text = data.contributorName
            posted_at.text = data.createdAt.subSequence(0, 10)
            post_title.text = data.postTitle
            post_body.text = data.postBody
            comment_count.text = data.applications.size.toString()+" Applications"

            if (data.image != null && data.image.isNotEmpty()) {
                ImageHelper.loadImageWithBlurEffect(activity, post_image, data.image)
            }

            comment_count.setOnClickListener(this)
            apply_btn.setOnClickListener(this)
            post_body.setOnClickListener(this)

        }


        override fun onClick(v: View?) {
            when (v?.id) {

                R.id.comment_count -> {
                    moveToNextActivity()
                }
            }
        }

        fun moveToNextActivity() {
            val intent = Intent(activity, PostFullActivity::class.java)
            intent.putExtra(Constants.POST_OBJECT, post as Serializable)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_up, R.anim.stay)
        }
    }
}