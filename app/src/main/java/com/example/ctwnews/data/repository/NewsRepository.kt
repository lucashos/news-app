package com.example.ctwnews.data.repository

import com.example.ctwnews.BuildConfig
import com.example.ctwnews.data.service.NewsService
import com.example.ctwnews.domain.entities.TopHeadlineResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsRepository(
    private val service: NewsService
) {
    fun listTopHeadlines(): Observable<TopHeadlineResponse> {
        return service.listTopHeadlines(BuildConfig.NEWS_SOURCE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.articles.sortedBy { it.publishingDate }
                it
            }
    }
}