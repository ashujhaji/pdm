package com.pixerapps.placie.ui.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.model.Comments
import com.pixerapps.placie.model.JobData

class ApplicantsAdapter(var jobData: JobData, var activity: Activity) :
    RecyclerView.Adapter<ApplicantsAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var currentPos: Int = 0

        fun bindData(data: Comments, pos: Int) {
            this.currentPos = pos

        }


        override fun onClick(v: View?) {
            when (v?.id) {

            }
        }
    }
}