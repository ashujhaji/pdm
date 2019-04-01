package com.pixerapps.placie.data.remote.api;


import com.pixerapps.placie.model.AdminPojo;
import com.pixerapps.placie.model.ApplyResponseModel;
import com.pixerapps.placie.model.PostPojo;
import com.pixerapps.placie.model.UserPojo;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //---------------------user routes----------------------------
    @FormUrlEncoded
    @POST("api/register")
    Call<UserPojo> userAuth(
            @Field("user_gid") String user_gid,
            @Field("user_name") String user_name,
            @Field("user_dp") String user_dp,
            @Field("user_email") String user_email
    );

    @FormUrlEncoded
    @POST("api/get_user_details")
    Call<UserPojo> getUserDetails(
            @Field("user_gid") String user_gid,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("api/update_user_details")
    Call<UserPojo> updateUserDetails(
            @Field("user_gid") String user_gid,
            @Field("token") String token,
            @Field("user_name") String userName,
            @Field("user_bio") String userBio,
            @Field("user_email") String userEmail,
            @Field("institute_id") String instituteId,
            @Field("course") String course,
            @Field("session") String session,
            @Field("user_type") String user_type,
            @Field("location") String location
    );


    @FormUrlEncoded
    @POST("api/get_all_posts")
    Call<PostPojo> getAllPosts(
            @Field("token") String token
    );


    @FormUrlEncoded
    @POST("api/apply_for_job")
    Call<ApplyResponseModel> applyForJob(
            @Field("token") String token,
            @Field("user_gid") String userGid,
            @Field("user_name") String userName,
            @Field("user_email") String userEmail,
            @Field("post_id") String postId
    );

    @FormUrlEncoded
    @POST("api/create_post")
    Call<PostPojo> createPost(
            @Field("token") String token,
            @Field("post_body") String postBody,
            @Field("post_title") String postTitle,
            @Field("image") String image,
            @Field("contributor_id") String contributorId,
            @Field("contributor_name") String contributorName,
            @Field("contributor_institute") String contributor_institute
    );

    @FormUrlEncoded
    @POST("api/get_post_by_user")
    Call<PostPojo> getPostByUser(
            @Field("token") String token,
            @Field("contributor_id") String contributorId
    );

    @FormUrlEncoded
    @POST("api/create_admin")
    Call<AdminPojo> registerAsAdmin(
            @Field("center_code") String centerCode,
            @Field("password") String password,
            @Field("institution_name") String instituteName
    );

    @FormUrlEncoded
    @POST("api/login_admin")
    Call<AdminPojo> loginAdmin(
            @Field("center_code") String centerCode,
            @Field("password") String password
    );
}
