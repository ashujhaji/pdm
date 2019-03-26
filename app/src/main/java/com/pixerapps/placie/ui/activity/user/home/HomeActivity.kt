package com.pixerapps.placie.ui.activity.user.home

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.View
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import com.pixerapps.placie.ui.activity.user.home.fragments.feed.FeedFragment
import com.pixerapps.placie.utils.Config
import kotlinx.android.synthetic.main.activity_user_home.*

class HomeActivity : BaseMvpActivity<HomeActivityContract.View, HomeActivityPresenter>(), HomeActivityContract.View,
    BottomNavigationView.OnNavigationItemSelectedListener {

    override var presenter: HomeActivityPresenter = HomeActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        showDefaultFragment()

        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun showDefaultFragment() {
        presenter.loadFragment(FeedFragment(),this,"userFeedFragment")
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_feed -> {
                presenter.loadFragment(FeedFragment(),this,"userFeedFragment")
                return true
            }
            R.id.nav_profile -> {
                return true
            }
            R.id.nav_info -> {

                return true
            }
            else -> return false
        }
    }
}