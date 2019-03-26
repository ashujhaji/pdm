package com.pixerapps.placie.data.remote.api;


import com.pixerapps.placie.model.UserPojo;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //----------------------access pojo route------------------------
    @FormUrlEncoded
    @POST("api/pojo_route")
    Call<String> getPojoAccess();


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

//    //----------------------load all hacks-----------------------------
//    @FormUrlEncoded
//    @POST("/get_hack_all")
//    Call<HackModel> getAllHacks(
//            @Field("offset") int offset,
//            @Field("limit") int limit
//    );
//
//    //--------------------load category wise hacks----------------------
//    @FormUrlEncoded
//    @POST("/get_hack_by_category")
//    Call<HackModel> getHackByCategory(
//            @Field("category_name") String category,
//            @Field("offset") int offset,
//            @Field("limit") int limit
//    );

}
