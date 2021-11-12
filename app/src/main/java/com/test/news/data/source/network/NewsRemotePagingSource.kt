package com.test.news.data.source.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.news.data.source.network.dto.NetworkArticle
import com.test.news.model.Headline
import javax.inject.Inject

/**
 * Created by Prasada Rao on 20/10/21 12:22 PM
 **/
class NewsRemotePagingSource @Inject constructor(
    private val api: NewsService
) : PagingSource<Int, Headline>() {
    override fun getRefreshKey(state: PagingState<Int, Headline>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Headline> {
        println("==========> load ${params.key}")
        return try {
            val nextPage = params.key?.plus(1) ?: 1

            val response = api.fetchNews(nextPage)
            LoadResult.Page(
                data = response.articles.map { article ->
                    article.convertToDomainEntity(nextPage)
                },
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}

private fun NetworkArticle.convertToDomainEntity(page: Int): Headline {
    return Headline(
        title = title,
        description = description,
        imageUrl = imageUrl,
        date = datePublished.substring(0, datePublished.indexOf('T')),
        source = source.name,
        page = page
    )
}