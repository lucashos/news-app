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


@Parcelize
data class HeadlineArticleResponse(
    val author: String,
    val content: String,
    val title: String,
    val description: String,
    @SerializedName("urlToImage") val imageUrl: String,
    @SerializedName("publishedAt") val publishingDate: Date
): Parcelable