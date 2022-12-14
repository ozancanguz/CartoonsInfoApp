package com.ozancanguz.cartoonsinfoapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ozancanguz.cartoonsinfoapp.R

class Utils {

    fun ImageView.loadImage(uri: String?) {
        val options = RequestOptions()

            .error(R.mipmap.ic_launcher)
        Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)

    }
}