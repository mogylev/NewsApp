package com.mohylev.newsapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
"status": "ok",
"totalResults": 157,
"articles": []
 **/

@Serializable
data class Response<E>(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResult: Int,
    @SerialName("articles") val articles: List<ArticleApiModel>,
)
