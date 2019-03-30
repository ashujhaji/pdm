package com.pixerapps.placie.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApplyResponseModel(
    @SerializedName("message") val message: String,
    @SerializedName("status") val success: Boolean
) : Serializable