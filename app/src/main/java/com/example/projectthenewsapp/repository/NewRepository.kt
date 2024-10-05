package com.example.projectthenewsapp.repository

import com.example.projectthenewsapp.api.RetrofitInstance
import com.example.projectthenewsapp.db.ArticleDatabase
import com.example.projectthenewsapp.models.Article


class NewRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}