package com.pixerapps.placie.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.pixerapps.placie.R;

public class Config {

    public static void setFragment(Fragment fragment, FragmentActivity fragmentActivity, String fragName){
        if (fragmentActivity.getSupportFragmentManager().findFragmentByTag(fragName)==null){
            FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainFrame, fragment, fragName);
            fragmentTransaction.commit();
        }
    }
}
