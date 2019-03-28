package com.pixerapps.placie.ui.activity.user.editProfile

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_user_edit_profile.*

class EditProfileActivity : BaseMvpActivity<EditProfileActivityContract.View, EditProfileActivityPresenter>(),
    EditProfileActivityContract.View, View.OnClickListener {

    override var presenter: EditProfileActivityPresenter = EditProfileActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit_profile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        showToolbar()
        updateFieldsWithExistingData()

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
        if (CurrentUserData.getInstance().userData[0].user_name.isNotEmpty()) {
            edit_user_name.setText(CurrentUserData.getInstance().userData[0].user_name)
        }
        if (CurrentUserData.getInstance().userData[0].user_email.isNotEmpty()) {
            edit_user_email.setText(CurrentUserData.getInstance().userData[0].user_email)
        }
        if (CurrentUserData.getInstance().userData[0].location.isNotEmpty()) {
            edit_user_location.setText(CurrentUserData.getInstance().userData[0].location)
        }
        if (CurrentUserData.getInstance().userData[0].location.isNotEmpty()) {
            edit_user_location.setText(CurrentUserData.getInstance().userData[0].location)
        }
        if (CurrentUserData.getInstance().userData[0].instituteId.isNotEmpty()) {
            edit_user_inst_id.setText(CurrentUserData.getInstance().userData[0].instituteId)
        }
        if (CurrentUserData.getInstance().userData[0].course.isNotEmpty()) {
            edit_user_course.setText(CurrentUserData.getInstance().userData[0].course)
        }
        if (CurrentUserData.getInstance().userData[0].session.isNotEmpty()) {
            edit_course_start.text = CurrentUserData.getInstance().userData[0].session.substring(0, 3)
            edit_course_end.text = CurrentUserData.getInstance().userData[0].session.substring(4)
        }
        if (CurrentUserData.getInstance().userData[0].user_bio.isNotEmpty()) {
            edit_user_bio.setText(CurrentUserData.getInstance().userData[0].user_bio)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.update_profile -> {
                presenter.updateUserProfile(
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