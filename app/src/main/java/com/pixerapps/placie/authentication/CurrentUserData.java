package com.pixerapps.placie.authentication;

import android.net.Uri;
import com.google.firebase.auth.FirebaseAuth;

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

    public String uid(){
        return mAuth.getCurrentUser().getUid();
    }

    public String displayName(){
        return mAuth.getCurrentUser().getDisplayName();
    }

    public Uri imageUrl(){
        return mAuth.getCurrentUser().getPhotoUrl();
    }


}
