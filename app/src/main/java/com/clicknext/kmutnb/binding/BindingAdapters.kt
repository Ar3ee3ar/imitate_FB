package com.clicknext.kmutnb.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.clicknext.kmutnb.R

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let { imageUrl ->
        imageView.load(imageUrl){
            placeholder(R.drawable.ic_circle)
            error(R.drawable.ic_circle)
        }
        imageView.tag = imageUrl
    }
}

@BindingAdapter("isLike")
fun bindDrawableStartCompat(textView: TextView, isLike: Boolean = false){
    var icon = ContextCompat.getDrawable(textView.context, R.mipmap.ic_like)
    if(isLike){
        icon = ContextCompat.getDrawable(textView.context, R.mipmap.ic_like_active)
    }
    textView.setCompoundDrawablesWithIntrinsicBounds(icon,null,null,null)
}