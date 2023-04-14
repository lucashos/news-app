package com.example.ctwnews.core

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://newsapi.org"

class Network {

    private val httpClient: OkHttpClient = createHttpClient()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(configureGson()))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(httpClient)
        .build()

    private fun configureGson() = GsonBuilder()
        .create()

    private fun createHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(getLoggerInterceptor())
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Api-Key", "4b50b8dfe2884682a731378fc6a5795d")
                .build()

            chain.proceed(request)
        }
        .build()

    private fun getLoggerInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}