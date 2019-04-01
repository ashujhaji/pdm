package com.pixerapps.placie.model

import com.google.gson.annotations.SerializedName

data class AdminPojo (
    @SerializedName("message") val message: String,
    @SerializedName("status") val success: Boolean,
    @SerializedName("data") val data: List<AdminData>
)

data class AdminData(
    @SerializedName("__v") val v:String,
    @SerializedName("_id") val  id :String,
    @SerializedName("token") val  token :String,
    @SerializedName("center_code") val  centerCode :String,
    @SerializedName("institution_name") val  institutionName :String,
    @SerializedName("institution_dp") val  institutionDp :String,
    @SerializedName("institution_email") val  institutionEmail :String,
    @SerializedName("created_at") val  created_at :String,
    @SerializedName("updated_at") val  updated_at :String,
    @SerializedName("status") val  status :String,
    @SerializedName("university") val  university :String,
    @SerializedName("student_details") val  student_details :Student,
    @SerializedName("placement_data") val placement_data : Placement
)

data class Student(
    @SerializedName("__v") val v:String,
    @SerializedName("_id") val  id :String,
    @SerializedName("roll_no") val  roll_no :String,
    @SerializedName("name") val  name :String,
    @SerializedName("session") val  session :String
)

data class Placement(
    @SerializedName("__v") val v:String,
    @SerializedName("_id") val  id :String,
    @SerializedName("year") val  year :String,
    @SerializedName("company_name") val  company_name :String,
    @SerializedName("total_placed_count") val  total_placed_count :String
)