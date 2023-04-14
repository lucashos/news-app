package com.example.ctwnews.feature.topheadlines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ctwnews.databinding.ItemTopHeadlineBinding
import com.example.ctwnews.databinding.ItemTopHeadlineHeaderBinding
import com.example.ctwnews.domain.entities.HeadlineArticleResponse

private const val NEWS_HEADER = 2
private const val NEWS_ITEM = 3

class TopHeadlinesAdapter(
    private val onItemClick: (HeadlineArticleResponse) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {
    private val articles = ArrayList<HeadlineArticleResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            NEWS_HEADER -> {
                TopHeadlinesHeaderViewHolder(
                    ItemTopHeadlineHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                val binding = ItemTopHeadlineBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                TopHeadlinesViewHolder(binding, onItemClick)
            }
        }
    }

    override fun getItemCount(): Int {
        return articles.size + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is TopHeadlinesViewHolder -> {
                holder.bind(articles[position - 1])
            }
            else -> { //Do nothing }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) NEWS_HEADER else NEWS_ITEM
    }

    fun updateDataset(items: List<HeadlineArticleResponse>) {
        articles.clear()
        articles.addAll(items)
        notifyDataSetChanged()
    }
}
