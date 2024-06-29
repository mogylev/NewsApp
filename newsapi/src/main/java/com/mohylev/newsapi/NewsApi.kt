package com.mohylev.newsapi

import androidx.annotation.IntRange
import com.mohylev.newsapi.models.ArticleApiModel
import com.mohylev.newsapi.models.Language
import com.mohylev.newsapi.models.Response
import com.mohylev.newsapi.models.SortBy
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/everything")
    fun getAllNews(
        @Query("q") query: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") languages: Array<Language>? = null,
        @Query("sortBy") sortBy: SortBy? = null,
        @Query("pageSize") @IntRange(from = 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1, to = 100) page: Int = 1
    ) : Result<Response<ArticleApiModel>>
}

fun newsApi(
    baseUrl: String, okHttpClient: OkHttpClient? = null
): NewsApi = retrofit(baseUrl = baseUrl, okHttpClient = okHttpClient).create()


private fun retrofit(
    baseUrl: String, okHttpClient: OkHttpClient?
): Retrofit {

    val newOkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(ApiKeyInterceptor("8eebafb13ce54b1aac32e8cb8a82de5e"))
        .build()

    return Retrofit.Builder().baseUrl(baseUrl)
        .client(newOkHttpClient)
        .addConverterFactory(
            Json.asConverterFactory(
                MediaType.get("application/json")
            )
        )
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .build()
}