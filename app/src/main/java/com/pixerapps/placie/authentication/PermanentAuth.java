package com.pixerapps.placie.authentication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.pixerapps.placie.R;
import com.pixerapps.placie.utils.Constants;
import com.pixerapps.placie.utils.MyPref;

public class PermanentAuth {

    private FirebaseAuth mAuth;
    private String TAG = "authstatus";
    private static PermanentAuth instance;
    private ProgressDialog dialog;

    public static PermanentAuth getInstance() {
        if (instance == null) {
            instance = new PermanentAuth();
        }
        return instance;
    }

    public void permanentAuthenticate(Activity activity, GoogleSignInAccount account) {
        mAuth = FirebaseAuth.getInstance();
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        if (mAuth.getCurrentUser() == null) {
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            showProgressDialog("Authenticating user",activity);
                            Log.d(TAG, "linkWithCredential:success");
                            MyPref.putString(Constants.USER_GID,task.getResult().getUser().getUid());
                            ServerAuth.getInstance().startAuthenticate(activity,dialog,task.getResult().getUser());
                            Log.d("uuuid", task.getResult().getUser().getUid());
                        } else {
                            Log.d(TAG, "linkWithCredential:failure", task.getException());
                        }
                    });
        } else {
            mAuth.signOut();
        }
    }

    public GoogleApiClient getGoogleApiClient(FragmentActivity context) {
        GoogleApiClient mGoogleApiClient;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(context, connectionResult -> {
                    Log.d(TAG, "something went wrong");
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        return mGoogleApiClient;
    }

    private void showProgressDialog(String message, Activity activity){
        dialog = new ProgressDialog(activity);
        dialog.setMessage(message);
        dialog.show();
    }
}
