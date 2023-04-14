package com.example.ctwnews.data.service

import com.example.ctwnews.domain.entities.TopHeadlineResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    fun listTopHeadlines(@Query("sources") sources: String): Observable<TopHeadlineResponse>
}