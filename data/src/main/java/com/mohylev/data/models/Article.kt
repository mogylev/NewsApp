package com.mohylev.data.models

import com.mohylev.database.models.ArticleEntity
import com.mohylev.database.models.SourceEntity
import java.time.Instant

data class Article(
    val id: Long,
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String,
    val publishDate: Instant,
    val content: String,
)

internal fun ArticleEntity.asExternalModel() = Article(
    id = id,
    source = source.asExternalModel(),
    author = author,
    title = title,
    description = description,
    url = url,
    imageUrl = imageUrl,
    publishDate = publishDate,
    content = content
)

internal fun SourceEntity.asExternalModel() = Source(
    id = id,
    name = name
)