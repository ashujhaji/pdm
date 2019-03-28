package com.pixerapps.placie.helper

import android.content.Context
import android.graphics.Bitmap
import android.support.annotation.NonNull
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.transition.Transition
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget


class ImageHelper {


    companion object {

        fun loadRoundLeader(context : Context, imageView: ImageView, @NonNull imageUrl: String) {
//            Glide.with(context)
//                .asBitmap()
//                .centerCrop()
//                .load(imageUrl).override(40, 40)
//                .into(object : SimpleTarget<Bitmap>() {
//                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                        val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(Base.getResources(), resource)
//                        circularBitmapDrawable.isCircular = true
//                        imageView.setImageDrawable(circularBitmapDrawable)
//                    }
//                })
        }
//
//        fun loadImageWithBlurEffect(imageView: ImageView, @NonNull imageUrl: String) {
//            GlideApp.with(Base.getContext())
//                .load(imageUrl)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .thumbnail(0.1f)
//                .into(imageView)
//        }

    }
}