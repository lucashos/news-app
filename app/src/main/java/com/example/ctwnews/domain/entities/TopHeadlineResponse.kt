package com.example.ctwnews.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class TopHeadlineResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<HeadlineArticleResponse>
) : Parcelable