package com.test.news.data.source.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasad Rao on 10-08-2020 19:44
 **/
data class NetworkNews(
  @SerializedName("status")
  val status: String,

  @SerializedName("totalResults")
  val totalResults: Long,

  @SerializedName("message")
  val message: String? = null,

  @SerializedName("articles")
  val articles: List<NetworkArticle> = emptyList()
)