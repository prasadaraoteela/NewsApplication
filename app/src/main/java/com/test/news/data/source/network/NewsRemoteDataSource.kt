package com.test.news.data.source.network

import com.test.news.data.Result
import com.test.news.data.source.DataSource
import com.test.news.data.source.network.dto.NetworkArticle
import com.test.news.model.Headline
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 19:42
 **/
class NewsRemoteDataSource @Inject constructor(
  private val api: NewsService
) : DataSource {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
    val news = api.getNews(page, pageSize)
    return if (news.isSuccessful) {
      Result.Success(
        news.body()?.articles?.map { article ->
          article.convertToDomainEntity(page)
        })
    } else {
      Result.Failure(news.message())
    }
  }

  override suspend fun saveHeadlines(headlines: List<Headline>) {
    throw IllegalStateException("Not required!")
  }
}

fun NetworkArticle.convertToDomainEntity(page: Int): Headline {
  return Headline(
    title = title,
    description = description,
    imageUrl = imageUrl,
    date = datePublished.substring(0, datePublished.indexOf('T')),
    source = source.name,
    page = page
  )
}
