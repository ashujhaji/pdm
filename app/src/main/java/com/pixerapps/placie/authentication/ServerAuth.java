package com.pixerapps.placie.authentication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseUser;
import com.pixerapps.placie.UserPojo;
import com.pixerapps.placie.data.remote.api.ApiClient;
import com.pixerapps.placie.data.remote.api.ApiInterface;
import com.pixerapps.placie.ui.activity.user.home.HomeActivity;
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


    protected void startAuthenticate(Activity activity,ProgressDialog progressDialog, FirebaseUser user){
        if (ApiClient.getClient()!=null){
            Call<UserPojo> call = ApiClient.getClient().create(ApiInterface.class)
                    .userAuth(user.getUid(),user.getDisplayName(),user.getPhotoUrl().toString(),user.getEmail());
            call.enqueue(new Callback<UserPojo>() {
                @Override
                public void onResponse(Call<UserPojo> call, Response<UserPojo> response) {
                    if (response.isSuccessful())  {
                        progressDialog.dismiss();
                        activity.startActivity(new Intent(activity,HomeActivity.class));
                        Toast.makeText(activity, "Authentication successful",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<UserPojo> call, Throwable t) {

                }
            });
        }
    }
}
