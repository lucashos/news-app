package com.example.ctwnews.feature.headlinearticle

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ctwnews.core.loadImage
import com.example.ctwnews.databinding.ActivityHeadlineArticleBinding
import com.example.ctwnews.domain.entities.HeadlineArticleResponse

class HeadlineArticleActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHeadlineArticleBinding.inflate(layoutInflater) }

    private val headline: HeadlineArticleResponse? by lazy {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable(EXTRA_HEADLINE_ARTICLE)
        } else {
            intent.extras?.getParcelable(EXTRA_HEADLINE_ARTICLE, HeadlineArticleResponse::class.java)
        }
    }

    companion object {
        const val EXTRA_HEADLINE_ARTICLE = "EXTRA_HEADLINE_ARTICLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        headline?.let { headline ->
            setupArticleView(headline)
        }
    }

    private fun setupArticleView(article: HeadlineArticleResponse) {
        binding.run {
            tvHeadlineArticleDescription.text = article.description
            tvHeadlineArticleAuthor.text = article.author
            tvHeadlineArticleContent.text = article.content
            tvHeadlineArticleTitle.text = article.title
            ivHeadlineArticleImage loadImage article.imageUrl
        }
    }
}
