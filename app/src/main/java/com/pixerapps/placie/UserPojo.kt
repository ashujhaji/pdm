package com.pixerapps.placie

import com.google.gson.annotations.SerializedName

data class UserPojo (
    @SerializedName("message") val message: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("token") val token: String
)