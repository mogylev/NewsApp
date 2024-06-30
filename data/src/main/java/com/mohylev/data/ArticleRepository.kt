package com.mohylev.data

import com.mohylev.data.models.Article
import com.mohylev.data.models.asExternalModel
import com.mohylev.database.dao.ArticleDao
import com.mohylev.newsapi.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepository(
    private val articleDao: ArticleDao,
    private val newsApi: NewsApi
) {

    fun observeArticles(): Flow<List<Article>> {
        return articleDao.getAll().map { articles ->
            articles.map { it.asExternalModel() }
        }
    }

    suspend fun search (query:String) : Flow<List<Article>> {
        newsApi.getAllNews()
        TODO("not implemented")
    }

    suspend fun fetchArticles() {
        newsApi.getAllNews().fold(
            onSuccess = {

            },
            onFailure = {

            }
        )
    }
}