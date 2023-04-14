package com.example.ctwnews.data

import com.example.ctwnews.data.repository.NewsRepository
import com.example.ctwnews.data.service.NewsService
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    factory { get<Retrofit>().create(NewsService::class.java) }

    factory { NewsRepository(get()) }
}