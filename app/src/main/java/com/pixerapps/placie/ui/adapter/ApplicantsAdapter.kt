package com.pixerapps.placie.ui.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixerapps.placie.R
import com.pixerapps.placie.model.Applications
import com.pixerapps.placie.model.JobData
import kotlinx.android.synthetic.main.layout_applicant.view.*

class ApplicantsAdapter(var jobData: JobData, var activity: Activity) :
    RecyclerView.Adapter<ApplicantsAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.layout_applicant, p0, false))
    }

    override fun getItemCount(): Int {
        return jobData.applications.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindData(jobData.applications[p1],p1)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var currentPos: Int = 0

        fun bindData(data: Applications, pos: Int) {
            this.currentPos = pos
            itemView.user_name.text = data.userName
            itemView.user_email.text = data.userEmail
        }


        override fun onClick(v: View?) {
            when (v?.id) {

            }
        }
    }
}