package com.test.news.data.source.network

import com.test.news.data.source.network.dto.NetworkNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Prasad Rao on 10-08-2020 19:49
 **/
interface NewsService {

    @GET("everything?q=movies&apiKey=079dac74a5f94ebdb990ecf61c8854b7")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NetworkNews>

    @GET("everything?q=movies&apiKey=079dac74a5f94ebdb990ecf61c8854b7")
    suspend fun fetchNews(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 20
    ): NetworkNews
}