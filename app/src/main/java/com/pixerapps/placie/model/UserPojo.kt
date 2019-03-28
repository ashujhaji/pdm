package com.pixerapps.placie.model

import com.google.gson.annotations.SerializedName

data class UserPojo (
    @SerializedName("message") val message: String,
    @SerializedName("status") val success: Boolean,
    @SerializedName("data") val data: List<UserData>
)

data class UserData(
    @SerializedName("__v") val v:String,
    @SerializedName("_id") val  id :String,
    @SerializedName("token") val  token :String,
    @SerializedName("user_gid") val  user_gid :String,
    @SerializedName("user_name") val  user_name :String,
    @SerializedName("user_dp") val  user_dp :String,
    @SerializedName("user_email") val  user_email :String,
    @SerializedName("created_at") val  created_at :String,
    @SerializedName("updated_at") val  updated_at :String,
    @SerializedName("college_name") val  college_name :String,
    @SerializedName("session") val  session :String,
    @SerializedName("user_type") val  user_type :String,
    @SerializedName("user_bio") val user_bio : String,
    @SerializedName("location") val location : String,
    @SerializedName("institute_id") val instituteId:String,
    @SerializedName("course") val course:String
)