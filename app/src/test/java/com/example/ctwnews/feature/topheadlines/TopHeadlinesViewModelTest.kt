package com.example.ctwnews.feature.topheadlines

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ctwnews.RxImmediateSchedulerRule
import com.example.ctwnews.data.repository.NewsRepository
import com.example.ctwnews.domain.entities.HeadlineArticleResponse
import com.example.ctwnews.domain.entities.TopHeadlineResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class TopHeadlinesViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testSchedulerRule = RxImmediateSchedulerRule()

    private val repository: NewsRepository = mockk()
    private lateinit var viewModel: TopHeadlinesViewModel

    @Before
    fun setUp() {
        viewModel = TopHeadlinesViewModel(repository)
    }

    @Test
    fun `When refresh news is called, then should list news`() {
        // Given
        val articles = listOf<HeadlineArticleResponse>(mockk())
        val topHeadlines: TopHeadlineResponse = mockk()

        every { topHeadlines.articles } returns articles
        every { repository.listTopHeadlines() } returns Observable.just(topHeadlines)

        // When
        viewModel.refreshNews()

        // Then
        verify(exactly = 1) { repository.listTopHeadlines() }
        Assert.assertEquals(articles, viewModel.headlineArticlesLiveData.value)
    }
}