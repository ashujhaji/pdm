package com.pixerapps.placie.authentication;

import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;

public class AnonymAuth {

    private FirebaseAuth mAuth;
    private String TAG = "authstatus";
    private static AnonymAuth instance;

    public static AnonymAuth getInstance() {
        if (instance == null) {
            instance = new AnonymAuth();
        }
        return instance;
    }


    public void authenticate() {
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null) {
            mAuth.signInAnonymously().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signin success");
//                    Constants.uid = mAuth.getCurrentUser().getUid();
                } else {
                    Log.d(TAG, "signin failed");
                }
            });
        }
    }
}
