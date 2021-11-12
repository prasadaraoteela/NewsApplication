package com.test.news.data.source.local

import com.test.news.data.Result
import com.test.news.data.source.DataSource
import com.test.news.data.source.local.room.dao.HeadlinesDao
import com.test.news.data.source.local.room.entity.DatabaseHeadline
import com.test.news.model.Headline
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 19:34
 **/
class NewsLocalDataSource @Inject constructor(
    private val headlinesDao: HeadlinesDao
) : DataSource {
    override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
        val headlines = headlinesDao.fetchHeadlines(page, pageSize).map { databaseHeadline ->
            databaseHeadline.convertToDomainHeadline()
        }
        return Result.Success(headlines)
    }

    override suspend fun saveHeadlines(headlines: List<Headline>) {
        headlinesDao.insertHeadlines(headlines.map { headline ->
            headline.convertToDatabaseHeadline()
        })
    }
}

private fun Headline.convertToDatabaseHeadline(): DatabaseHeadline {
    return DatabaseHeadline(
        title = title,
        description = description,
        imageUrl = imageUrl,
        datePublished = date,
        source = source,
        page = page
    )
}

private fun DatabaseHeadline.convertToDomainHeadline(): Headline {
    return Headline(
        title = title,
        description = description,
        imageUrl = imageUrl,
        date = datePublished,
        source = source,
        page = page
    )
}
