package com.pixerapps.placie.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class JobPojo(
    @SerializedName("message") val message: String,
    @SerializedName("status") val success: Boolean,
    @SerializedName("data") val data: List<JobData>
) : Serializable

data class JobData(
    @SerializedName("__v") val v: String,
    @SerializedName("_id") val id: String,
    @SerializedName("post_id") val postId: String,
    @SerializedName("post_body") val postBody: String,
    @SerializedName("post_title") val postTitle: String,
    @SerializedName("category") val category: String,
    @SerializedName("language") val language: String,
    @SerializedName("status") val status: String,
    @SerializedName("country") val country: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("contributor_name") val contributorName: String,
    @SerializedName("contributor_id") val contributorId: String,
    @SerializedName("external_url") val externalUrl: String,
    @SerializedName("image") val image: String,
    @SerializedName("video") val video: String,
    @SerializedName("applications") val applications:List<Applications>
) : Serializable

data class Applications(
    @SerializedName("__v") val v: String,
    @SerializedName("_id") val id: String,
    @SerializedName("user_gid") val userGid: String,
    @SerializedName("user_name") val userName: String,
    @SerializedName("user_email") val userEmail: String,
    @SerializedName("is_rejected") val isRejected: String
):Serializable
