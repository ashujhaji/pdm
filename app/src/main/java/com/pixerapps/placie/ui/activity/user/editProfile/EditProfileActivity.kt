package com.pixerapps.placie.ui.activity.user.editProfile

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import com.pixerapps.placie.R
import com.pixerapps.placie.helper.ImageHelper
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.activity_user_edit_profile.*

class EditProfileActivity : BaseMvpActivity<EditProfileActivityContract.View, EditProfileActivityPresenter>(),
    EditProfileActivityContract.View, View.OnClickListener {

    override var presenter: EditProfileActivityPresenter = EditProfileActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit_profile)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        showToolbar()
        updateFieldsWithExistingData()

        update_profile.setOnClickListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showToolbar() {
        setSupportActionBar(edit_toolbar as Toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Edit Profile"
        (edit_toolbar as Toolbar).setTitleTextColor(resources.getColor(R.color.grey_500))
        (edit_toolbar as Toolbar).setTitleTextAppearance(this, R.style.futuraTextAppearance)
    }


    override fun updateFieldsWithExistingData() {
        if (Constants.USER_DETAILS.user_dp != null) {
            ImageHelper.loadRoundLeader(this, user_dp, Constants.USER_DETAILS.user_dp)
        }

        if (Constants.USER_DETAILS.user_name != null) {
            edit_user_name.setText(Constants.USER_DETAILS.user_name)
        }
        if (Constants.USER_DETAILS.user_email != null) {
            edit_user_email.setText(Constants.USER_DETAILS.user_email)
        }
        if (Constants.USER_DETAILS.location != null) {
            edit_user_location.setText(Constants.USER_DETAILS.location)
        }
        if (Constants.USER_DETAILS.location != null) {
            edit_user_location.setText(Constants.USER_DETAILS.location)
        }
        if (Constants.USER_DETAILS.instituteId != null) {
            edit_user_inst_id.setText(Constants.USER_DETAILS.instituteId)
        }
        if (Constants.USER_DETAILS.course != null) {
            edit_user_course.setText(Constants.USER_DETAILS.course)
        }
        if (Constants.USER_DETAILS.session != null) {
            edit_course_start.text = Constants.USER_DETAILS.session.substring(0, 4)
            edit_course_end.text = Constants.USER_DETAILS.session.substring(5)
        }
        if (Constants.USER_DETAILS.user_bio != null) {
            edit_user_bio.setText(Constants.USER_DETAILS.user_bio)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.update_profile -> {
                presenter.updateUserProfile(
                    this,
                    edit_user_name.text.toString(),
                    edit_user_email.text.toString(),
                    edit_user_location.text.toString(),
                    edit_user_inst_id.text.toString(),
                    edit_user_course.text.toString(),
                    edit_course_start.text.toString(),
                    edit_course_end.text.toString(),
                    edit_user_bio.text.toString()
                )
            }
        }
    }

}