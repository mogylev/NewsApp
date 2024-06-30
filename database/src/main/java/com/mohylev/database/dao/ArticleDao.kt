package com.mohylev.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mohylev.database.models.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    fun getAll () : Flow<List<ArticleEntity>>

    @Insert
    suspend fun insert (articleEntity: ArticleEntity)

    @Delete
    suspend fun remove (articleEntity: ArticleEntity)

    @Query("DELETE FROM articles")
    suspend fun clean()
}