package com.example.ctwnews.feature

import com.example.ctwnews.feature.topheadlines.TopHeadlinesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val featureModule = module {
    viewModelOf(::TopHeadlinesViewModel)
}