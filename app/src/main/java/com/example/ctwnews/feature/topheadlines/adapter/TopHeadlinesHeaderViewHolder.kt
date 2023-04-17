package com.example.ctwnews.feature.topheadlines.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ctwnews.databinding.ItemTopHeadlineHeaderBinding

class TopHeadlinesHeaderViewHolder(
    private val binding: ItemTopHeadlineHeaderBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(sourceName: String) {
        binding.newsHeader.text = sourceName
        binding.newsHeader.visibility = View.VISIBLE
    }
}