package com.test.news.data.source.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Created by Prasad Rao on 12-08-2020 12:39
 **/
@Entity(tableName = "headline", primaryKeys = ["title", "description"])
data class DatabaseHeadline(

  @ColumnInfo(name = "page")
  val page: Int = 1,

  @ColumnInfo(name = "author")
  val author: String = "",

  @ColumnInfo(name = "title")
  val title: String,

  @ColumnInfo(name = "description")
  val description: String,

  @ColumnInfo(name = "news_source_link")
  val url: String = "",

  @ColumnInfo(name = "news_image_url")
  val imageUrl: String,

  @ColumnInfo(name = "date_published")
  val datePublished: String,

  @ColumnInfo(name = "content")
  val content: String? = null,

  @ColumnInfo(name = "source")
  val source: String
)