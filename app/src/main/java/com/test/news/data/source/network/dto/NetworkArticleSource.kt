package com.test.news.data.source.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Prasad Rao on 11-08-2020 11:32
 **/
data class NetworkArticleSource(
  @SerializedName("id")
  val id: String? = null,
  @SerializedName("name")
  val name: String
)