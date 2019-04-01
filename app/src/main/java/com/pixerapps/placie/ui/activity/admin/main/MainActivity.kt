package com.pixerapps.placie.ui.activity.admin.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.activity.admin.main.fragment.feed.AdminFeedFragment
import com.pixerapps.placie.ui.activity.admin.main.fragment.profile.AdminProfileFragment
import com.pixerapps.placie.ui.activity.createPost.CreatePostActivity
import kotlinx.android.synthetic.main.activity_admin_main.*

class MainActivity : BaseMvpActivity<MainActivityContract.View, MainActivityPresenter>(), MainActivityContract.View,
    BottomNavigationView.OnNavigationItemSelectedListener {

    override var presenter: MainActivityPresenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        showDefaultFragment()

        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun showDefaultFragment() {
        presenter.loadFragment(AdminFeedFragment(), this, "AdminFeedFragment")
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_feed -> {
                presenter.loadFragment(AdminFeedFragment(), this, "AdminFeedFragment")
                return true
            }
            R.id.nav_add -> {
                startActivity(Intent(this,CreatePostActivity::class.java))
                return false
            }
            R.id.nav_profile -> {
                presenter.loadFragment(AdminProfileFragment(), this, "AdminprofileFeedFragment")
                return true
            }
            else -> return false
        }
    }


}