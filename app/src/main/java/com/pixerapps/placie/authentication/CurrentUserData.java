package com.pixerapps.placie.authentication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.pixerapps.placie.callback.OnUserDataLoadedListener;
import com.pixerapps.placie.data.remote.api.ApiClient;
import com.pixerapps.placie.data.remote.api.ApiInterface;
import com.pixerapps.placie.model.UserData;
import com.pixerapps.placie.model.UserPojo;
import com.pixerapps.placie.ui.activity.authentication.AuthActivity;
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

    public static CurrentUserData getInstance() {
        mAuth = FirebaseAuth.getInstance();
        if (instance == null) {
            instance = new CurrentUserData();
        }
        return instance;
    }

    public void getUserDetails(OnUserDataLoadedListener callback) {
        if (ApiClient.getClient() != null) {
            Call<UserPojo> call = ApiClient.getClient().create(ApiInterface.class)
                    .getUserDetails(MyPref.getString(Constants.USER_GID, ""),
                            MyPref.getString(Constants.USER_TOKEN, ""));
            call.enqueue(new Callback<UserPojo>() {
                @Override
                public void onResponse(@NonNull Call<UserPojo> call, @NonNull Response<UserPojo> response) {
                    if (response.isSuccessful() && response.body().getSuccess()) {
                        callback.onUserDataLoaded(response.body());
                        Log.d("authstatus", response.body().getData().toString());
                    } else Log.d("authstatus", response.message());
                }

                @Override
                public void onFailure(Call<UserPojo> call, Throwable t) {
                    Log.d("authstatus", t.getMessage());
                }
            });
        }
    }


    public void logout(Activity activity) {
        mAuth.signOut();
        MyPref.putString(Constants.USER_GID, "");
        MyPref.putString(Constants.USER_TOKEN, "");
        MyPref.putBoolean(Constants.IS_USER_LOGGED_IN, false);
        activity.startActivity(new Intent(activity, AuthActivity.class));
    }
}
