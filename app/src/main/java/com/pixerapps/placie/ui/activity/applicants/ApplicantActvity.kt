package com.pixerapps.placie.ui.activity.applicants

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.pixerapps.placie.R
import com.pixerapps.placie.model.JobData
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.adapter.ApplicantsAdapter
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.activity_applicants.*

class ApplicantActvity : BaseMvpActivity<ApplicantContract.View, ApplicantPresenter>(),
    ApplicantContract.View {
    override var presenter: ApplicantPresenter = ApplicantPresenter()
    var adapter: ApplicantsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_applicants)

        showToolbar()
        if (intent.extras != null) {
            showData(intent?.extras?.get(Constants.JOB_OBJECT) as JobData)
        }

    }

    override fun showToolbar() {
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (toolbar as Toolbar).title = "Post"
        (toolbar as Toolbar).setTitleTextColor(ContextCompat.getColor(this, R.color.grey_800))
        (toolbar as Toolbar).setTitleTextAppearance(this, R.style.futuraTextAppearance)
    }

    override fun showData(applicants: JobData) {
        adapter = ApplicantsAdapter(applicants, this)
        val linearLayoutManager = LinearLayoutManager(this)
        applicant_recycler.layoutManager = linearLayoutManager
        applicant_recycler.adapter = adapter

    }

    override fun showToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}