package com.pixerapps.placie.ui.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pixerapps.placie.R
import com.pixerapps.placie.model.Comments

class CommentAdapter(var list: List<Comments>, var activity: Activity) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CommentAdapter.ViewHolder {
        return CommentAdapter.ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.layout_comment, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindData(list[p1], p1)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentPos: Int = 0


        var user_dp: ImageView = itemView.findViewById(R.id.user_dp)
        var user_name: TextView = itemView.findViewById(R.id.user_name)
        var comment: TextView = itemView.findViewById(R.id.comment)

        fun bindData(data: Comments, pos: Int) {
            this.currentPos = pos

            user_name.text = data.commentedBy
            comment.text = data.commentBody


        }



    }
}