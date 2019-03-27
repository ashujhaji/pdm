package com.pixerapps.placie.ui.activity.user.home.fragments.profile

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.*
import com.pixerapps.placie.R
import com.pixerapps.placie.authentication.CurrentUserData
import com.pixerapps.placie.mvp.BaseMvpFragment
import com.pixerapps.placie.ui.activity.user.home.HomeActivity
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
        showUserDetails()
        showViepager()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.profile_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.nav_logout -> {

            }
        }
        return false
    }

    override fun showToolbar() {
        (activity as HomeActivity).setSupportActionBar(toolbar as Toolbar)
        (toolbar as Toolbar).title = ""

    }

    override fun showUserDetails() {
        if (CurrentUserData.getInstance().userData.size!=0){
            user_name.text = CurrentUserData.getInstance().userData[0].user_name
            if (CurrentUserData.getInstance().userData[0].user_type != null && CurrentUserData.getInstance().userData[0].college_name != null && CurrentUserData.getInstance().userData[0].location != null) {
                user_detail.text = CurrentUserData.getInstance().userData[0].user_type + "|" +
                        CurrentUserData.getInstance().userData[0].college_name + "|" +
                        CurrentUserData.getInstance().userData[0].location
            }
        }
    }

    override fun showViepager() {
        var pagerAdapter = ProfilePagerAdapter(activity!!.supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}