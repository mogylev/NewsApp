package com.mohylev.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @Embedded(prefix = "source.") val source: SourceEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String,
    val publishDate: Instant,
    val content: String,
)

data class SourceEntity(
    val id: String,
    val name: String
)