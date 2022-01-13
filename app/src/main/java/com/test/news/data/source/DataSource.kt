package com.test.news.data.source

import com.test.news.data.Result
import com.test.news.model.Headline

/**
 * Created by Prasad Rao on 10-08-2020 19:20
 **/
interface DataSource {

  suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>>

  suspend fun saveHeadlines(headlines: List<Headline>)
}