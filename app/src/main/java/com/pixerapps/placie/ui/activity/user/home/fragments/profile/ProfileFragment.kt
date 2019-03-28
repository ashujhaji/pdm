package com.pixerapps.placie.ui.activity.user.home.fragments.profile

import android.app.Dialog
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.TextView
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.user.home.HomeActivity
import com.pixerapps.placie.utils.Constants
import kotlinx.android.synthetic.main.fragment_user_profile.*

class ProfileFragment : BaseMvpFragment<ProfileContract.View, ProfilePresenter>(), ProfileContract.View {
    override var presenter: ProfilePresenter = ProfilePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showToolbar()
        showViepager()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.profile_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.nav_logout -> {
                showLogoutDialog()
            }
        }
        return false
    }

    override fun showToolbar() {
        (activity as HomeActivity).setSupportActionBar(toolbar as Toolbar)
        (toolbar as Toolbar).title = ""

    }

    override fun showUserDetails() {
            user_name.text = Constants.USER_DETAILS.user_name
            if (Constants.USER_DETAILS.user_type!=null && Constants.USER_DETAILS.college_name!=null && Constants.USER_DETAILS.location!=null) {
                user_detail.text = Constants.USER_DETAILS.user_type + "|" +
                        Constants.USER_DETAILS.college_name + "|" +
                        Constants.USER_DETAILS.location
            }
    }

    override fun showViepager() {
        var pagerAdapter = ProfilePagerAdapter(activity!!.supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        showUserDetails()
        super.onResume()
    }

    override fun showLogoutDialog() {
        val logout : TextView
        val cancel : TextView
        val dialog = Dialog(context!!)
        dialog.setContentView(R.layout.dialog_user_logout)
        dialog.show()

        logout = dialog.findViewById(R.id.logout)
        cancel = dialog.findViewById(R.id.cancel)

        logout.setOnClickListener {
            CurrentUserData.getInstance().logout(activity)
        }

        cancel.setOnClickListener {
            dialog.dismiss()
        }

    }
}