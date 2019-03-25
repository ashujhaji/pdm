package com.pixerapps.placie

import android.app.Application
import android.content.ContextWrapper
import com.pixerapps.placie.utils.MyPref

class Global : Application() {

    override fun onCreate() {
        super.onCreate()

        MyPref.Builder().setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}