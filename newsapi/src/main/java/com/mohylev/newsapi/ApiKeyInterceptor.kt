package com.mohylev.newsapi

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder().addHeader("X-Api-Key", apiKey).build()
        return chain.proceed(newRequest)
    }
}