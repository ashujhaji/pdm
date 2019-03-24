package com.pixerapps.placie.data.remote.api;


import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //----------------------access pojo route------------------------
    @FormUrlEncoded
    @POST("/pojo_route")
    Call<String> getPojoAccess();

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
