package com.pixerapps.placie.authentication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.firebase.auth.FirebaseUser;
import com.pixerapps.placie.model.UserPojo;
import com.pixerapps.placie.data.remote.api.ApiClient;
import com.pixerapps.placie.data.remote.api.ApiInterface;
import com.pixerapps.placie.ui.activity.user.home.HomeActivity;
import com.pixerapps.placie.utils.Constants;
import com.pixerapps.placie.utils.MyPref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerAuth {
    private static ServerAuth instance;
    public static synchronized ServerAuth getInstance(){
        if (instance==null){
            instance = new ServerAuth();
        }
        return instance;
    }


    protected void startAuthenticate(Activity activity,ProgressDialog progressDialog,@NonNull FirebaseUser user){
        if (ApiClient.getClient()!=null){
            Call<UserPojo> call = ApiClient.getClient().create(ApiInterface.class)
                    .userAuth(user.getUid(),user.getDisplayName(),user.getPhotoUrl().toString(),user.getEmail());
            call.enqueue(new Callback<UserPojo>() {
                @Override
                public void onResponse(@NonNull Call<UserPojo> call, @NonNull Response<UserPojo> response) {
                    if (response.isSuccessful()&&response.body().getSuccess())  {
                        progressDialog.dismiss();
                        MyPref.putBoolean(Constants.IS_USER_LOGGED_IN,true);
                        MyPref.putString(Constants.USER_TOKEN,response.body().getData().get(0).getToken());
                        activity.startActivity(new Intent(activity,HomeActivity.class));
                        Log.d("authstatus",user.getDisplayName()+user.getEmail());
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
