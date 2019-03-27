package com.pixerapps.placie.authentication;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.pixerapps.placie.data.remote.api.ApiClient;
import com.pixerapps.placie.data.remote.api.ApiInterface;
import com.pixerapps.placie.model.UserData;
import com.pixerapps.placie.model.UserPojo;
import com.pixerapps.placie.utils.Constants;
import com.pixerapps.placie.utils.MyPref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class CurrentUserData {
    private static CurrentUserData instance;
    private static FirebaseAuth mAuth;
    public List<UserData> userData = new ArrayList<>();

    public static CurrentUserData getInstance() {
        mAuth = FirebaseAuth.getInstance();
        if (instance == null) {
            instance = new CurrentUserData();
        }
        return instance;
    }

    public String uid(){
        return mAuth.getCurrentUser().getUid();
    }

    public String displayName(){
        return mAuth.getCurrentUser().getDisplayName();
    }

    public Uri imageUrl(){
        return mAuth.getCurrentUser().getPhotoUrl();
    }

    public void getUserDetails(){
        if (ApiClient.getClient()!=null){
            Call<UserPojo> call = ApiClient.getClient().create(ApiInterface.class)
                    .getUserDetails(MyPref.getString(Constants.USER_GID,""),
                            MyPref.getString(Constants.USER_TOKEN,""));
            call.enqueue(new Callback<UserPojo>() {
                @Override
                public void onResponse(@NonNull Call<UserPojo> call, @NonNull Response<UserPojo> response) {
                    if (response.isSuccessful()&&response.body().getSuccess())  {
                        userData.addAll(response.body().getData());
                        Log.d("authstatus",response.body().getData().toString());
                    }else Log.d("authstatus",response.message());
                }

                @Override
                public void onFailure(Call<UserPojo> call, Throwable t) {
                    Log.d("authstatus",t.getMessage());
                }
            });
        }
    }


}
