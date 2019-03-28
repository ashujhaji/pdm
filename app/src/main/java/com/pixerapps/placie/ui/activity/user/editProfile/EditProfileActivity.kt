package com.pixerapps.placie.ui.activity.user.editProfile

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity

class EditProfileActivity : BaseMvpActivity<EditProfileActivityContract.View, EditProfileActivityPresenter>(),
    EditProfileActivityContract.View{

    override var presenter: EditProfileActivityPresenter = EditProfileActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit_profile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

    }

}