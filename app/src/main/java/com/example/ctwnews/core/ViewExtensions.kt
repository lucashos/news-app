package com.example.ctwnews.core

import android.widget.ImageView
import com.bumptech.glide.Glide

infix fun ImageView.loadImage(path: String) = Glide.with(this).load(path).into(this)