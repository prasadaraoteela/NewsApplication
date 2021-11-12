package com.test.news.di

import com.google.gson.Gson
import com.test.news.data.source.network.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Prasad Rao on 10-08-2020 19:58
 **/
@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsService = retrofit.create(NewsService::class.java)

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
}