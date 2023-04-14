package com.example.ctwnews.feature.topheadlines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ctwnews.databinding.ActivityTopHeadlinesBinding
import com.example.ctwnews.domain.entities.HeadlineArticleResponse
import com.example.ctwnews.feature.headlinearticle.HeadlineArticleActivity
import com.example.ctwnews.feature.headlinearticle.HeadlineArticleActivity.Companion.EXTRA_HEADLINE_ARTICLE
import com.example.ctwnews.feature.topheadlines.adapter.TopHeadlinesAdapter
import org.koin.android.ext.android.inject

class TopHeadlinesActivity : AppCompatActivity() {
    private val binding by lazy { ActivityTopHeadlinesBinding.inflate(layoutInflater) }

    private val viewModel: TopHeadlinesViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.refreshNews()
        setupSwipeRefresh()
        setupRecyclerView()
        setupObservables()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshNews()
        }
    }

    private fun setupRecyclerView() {
        binding.rvNewsList.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.rvNewsList.adapter = TopHeadlinesAdapter(::onNewsClick)
    }

    private fun setupObservables() {
        viewModel.headlineArticlesLiveData.observe(this) { result ->
            updateRecyclerViewDataset(result)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun updateRecyclerViewDataset(articles: List<HeadlineArticleResponse>) {
        (binding.rvNewsList.adapter as TopHeadlinesAdapter).updateDataset(articles)
    }

    private fun onNewsClick(article: HeadlineArticleResponse) {
        goToDetailsActivity(article)
    }

    private fun goToDetailsActivity(article: HeadlineArticleResponse) {
        startActivity(
            Intent(
                this,
                HeadlineArticleActivity::class.java
            ).putExtra(EXTRA_HEADLINE_ARTICLE, article)
        )
    }
}