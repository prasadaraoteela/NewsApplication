package com.test.news.headlines

import androidx.paging.PagingData
import com.test.news.data.Result
import com.test.news.data.repository.NewsRepository
import com.test.news.data.source.network.convertToDomainEntity
import com.test.news.data.source.network.dto.NetworkNews
import com.test.news.model.Headline
import com.test.news.util.TestResourceReader
import kotlinx.coroutines.flow.Flow

/**
 * Created by Prasada Rao on 10/04/22 6:46 PM
 **/
class FakeNewsRepository : NewsRepository {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {

    val newsResult: NetworkNews? =
      TestResourceReader.readNetworkNewsResponse("headlines_success_response.json")

    val headlines = newsResult?.articles?.map { it.convertToDomainEntity(1) } ?: emptyList()

    return Result.Success(headlines)
  }

  override fun fetchPagingHeadlines(): Flow<PagingData<Headline>> {
    TODO("Not yet implemented")
  }
}