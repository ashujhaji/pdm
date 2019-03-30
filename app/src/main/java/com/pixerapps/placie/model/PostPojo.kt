package com.pixerapps.placie.model

import com.google.gson.annotations.SerializedName

data class PostPojo(
    @SerializedName("message") val message: String,
    @SerializedName("status") val success: Boolean,
    @SerializedName("data") val data: List<PostData>
)

data class PostData(
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
    @SerializedName("contributor_institute") val contributorInstitute: String,
    @SerializedName("comments") val comments: List<Comments>,
    @SerializedName("is_job_post") val isJobPost: Boolean,
    @SerializedName("external_url") val externalUrl: String,
    @SerializedName("image") val image: String,
    @SerializedName("video") val video : String
)

data class Comments(
    @SerializedName("__v") val v: String,
    @SerializedName("_id") val id: String,
    @SerializedName("comment_id") val commentId: String,
    @SerializedName("comment_body") val commentBody: String,
    @SerializedName("commented_at") val commentedAt: String,
    @SerializedName("commented_by") val commentedBy: String,
    @SerializedName("image") val image: String
)