package com.pixerapps.placie.helper

import android.content.Context
import android.support.annotation.NonNull
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class ImageHelper {


    companion object {

        fun loadRoundLeader(context: Context, imageView: ImageView, @NonNull imageUrl: String) {
            Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .into(imageView)
        }

        fun loadImageWithBlurEffect(context: Context, imageView: ImageView, @NonNull imageUrl: String) {
            Glide.with(context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.1f)
                .into(imageView)
        }

    }
}