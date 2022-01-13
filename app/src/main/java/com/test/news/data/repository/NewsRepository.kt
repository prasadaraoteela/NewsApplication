package com.test.news.data.repository

import androidx.paging.PagingData
import com.test.news.data.Result
import com.test.news.model.Headline
import kotlinx.coroutines.flow.Flow

/**
 * Created by Prasad Rao on 10-08-2020 20:02
 **/
interface NewsRepository {

  suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>>

  fun fetchPagingHeadlines(): Flow<PagingData<Headline>>
}