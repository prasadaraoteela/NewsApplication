package com.test.news.data.source.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasad Rao on 10-08-2020 19:45
 **/
data class NetworkArticle(
    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("urlToImage")
    val imageUrl: String,

    @SerializedName("publishedAt")
    val datePublished: String,

    @SerializedName("content")
    val content: String? = null,

    @SerializedName("source")
    val source: NetworkArticleSource
)