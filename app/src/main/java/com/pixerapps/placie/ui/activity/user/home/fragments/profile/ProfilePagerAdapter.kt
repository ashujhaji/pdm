package com.pixerapps.placie.ui.activity.user.home.fragments.profile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.about.ProfileAboutFragment
import com.pixerapps.placie.ui.activity.user.home.fragments.profile.fragments.posts.ProfilePostFragment

class ProfilePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        when (p0) {
            0 -> {
                return ProfilePostFragment()
            }
            1 -> {
                return ProfileAboutFragment()
            }
        }
        return null
    }


    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Posts"
            }

            1 -> {
                return "About"
            }
        }
        return null
    }
}