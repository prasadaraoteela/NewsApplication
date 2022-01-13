package com.test.news.di

import com.test.news.data.repository.DefaultNewsRepository
import com.test.news.data.repository.NewsRepository
import com.test.news.data.source.DataSource
import com.test.news.data.source.local.NewsLocalDataSource
import com.test.news.data.source.network.NewsRemoteDataSource
import com.test.news.di.qualifier.LocalNewsDataSource
import com.test.news.di.qualifier.RemoteNewsDataSource
import com.test.news.di.scope.ActivityScoped
import com.test.news.headlines.HeadlinesViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Prasad Rao on 10-08-2020 20:21
 **/
@Module
abstract class DataModule {

    @Binds
    @LocalNewsDataSource
    abstract fun bindLocalNewsDataSource(source: NewsLocalDataSource): DataSource

    @Binds
    @RemoteNewsDataSource
    abstract fun bindRemoteNewsDataSource(source: NewsRemoteDataSource): DataSource

    @Binds
    abstract fun bindNewsRepository(repository: DefaultNewsRepository): NewsRepository
}