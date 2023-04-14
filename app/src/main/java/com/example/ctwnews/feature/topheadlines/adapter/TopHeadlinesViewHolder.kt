package com.example.ctwnews.feature.topheadlines.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ctwnews.core.loadImage
import com.example.ctwnews.databinding.ItemTopHeadlineBinding
import com.example.ctwnews.domain.entities.HeadlineArticleResponse

class TopHeadlinesViewHolder(
    private val binding: ItemTopHeadlineBinding,
    private val onItemClick: (HeadlineArticleResponse) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: HeadlineArticleResponse) {
        binding.run {
            tvTopHeadlineTitle.text = article.title
            tvTopHeadlineDescription.text = article.description
            ivTopHeadlineImage loadImage article.imageUrl
            root.setOnClickListener { onItemClick(article) }
        }
    }
}