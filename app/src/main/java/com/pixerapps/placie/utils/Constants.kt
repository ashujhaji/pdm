package com.pixerapps.placie.utils

import com.pixerapps.placie.model.AdminData
import com.pixerapps.placie.model.UserData

object Constants {
    const val API_BASE_URL = "http://192.168.43.23:3000/"


    //----------------------room constant------------------
    const val ROOM_DB_NAME = "PlacieRoomDb"


    //---------------preferences key---------------------
    const val IS_USER_LOGGED_IN = "isUserLoggedIn"
    const val IS_ADMIN_LOGGED_IN = "isAdminLoggedIn"

    const val USER_GID = "userGid"
    const val USER_TOKEN = "userToken"
    lateinit var USER_DETAILS : UserData

    const val ADMIN_ID = "adminId"
    lateinit var ADMIN_DETAILS : AdminData



    //-----------------------post constants-----------------------
    const val POST_OBJECT = "postObject"
}