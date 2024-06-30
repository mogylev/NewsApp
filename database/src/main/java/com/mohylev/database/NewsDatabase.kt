package com.mohylev.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohylev.database.models.ArticleEntity
import com.mohylev.database.dao.ArticleDao
import com.mohylev.database.utils.InstantConverter

@Database(version = 1, entities = [ArticleEntity::class])
@TypeConverters(InstantConverter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticleDao
}

fun newsDataBase (appContext : Context) : NewsDatabase {
    val dataBase = Room.databaseBuilder(appContext,NewsDatabase::class.java,"news-database")
    return dataBase.build()
}