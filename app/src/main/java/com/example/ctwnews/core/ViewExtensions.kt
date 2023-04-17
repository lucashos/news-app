package com.example.ctwnews.core

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

infix fun ImageView.loadImage(path: String) = Glide.with(this)
    .load(path)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .into(this)