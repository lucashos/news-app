package com.example.ctwnews.feature.topheadlines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ctwnews.data.repository.NewsRepository
import com.example.ctwnews.domain.entities.HeadlineArticleResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable

class TopHeadlinesViewModel(
    private val repository: NewsRepository
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val _headlineArticlesLiveData = MutableLiveData<List<HeadlineArticleResponse>>()
    val headlineArticlesLiveData
        get() = _headlineArticlesLiveData

    fun refreshNews() {
        repository.listTopHeadlines().subscribe({
            _headlineArticlesLiveData.postValue(it.articles)
        }, {
            it.printStackTrace()
        }).also { disposables.add(it) }
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}