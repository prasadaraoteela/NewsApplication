package com.test.news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.news.data.Result
import com.test.news.data.source.DataSource
import com.test.news.data.source.network.NewsRemotePagingSource
import com.test.news.di.qualifier.LocalNewsDataSource
import com.test.news.di.qualifier.RemoteNewsDataSource
import com.test.news.model.Headline
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 20:03
 **/
class DefaultNewsRepository @Inject constructor(
  @LocalNewsDataSource private val localDataSource: DataSource,
  @RemoteNewsDataSource private val remoteDataSource: DataSource,
  private val pagingSource: NewsRemotePagingSource
) : NewsRepository {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
    val result = remoteDataSource.fetchHeadlines(page, pageSize)
    if (result is Result.Success) {
      localDataSource.saveHeadlines(result.data ?: emptyList())
    }
    return localDataSource.fetchHeadlines(page, pageSize)
  }

  override fun fetchPagingHeadlines(): Flow<PagingData<Headline>> {
    return Pager(config = PagingConfig(pageSize = 20)) {
      pagingSource
    }.flow
  }
}