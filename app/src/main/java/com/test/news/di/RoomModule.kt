package com.test.news.di

import android.content.Context
import androidx.room.Room
import com.test.news.data.source.local.room.NewsDatabase
import com.test.news.data.source.local.room.dao.HeadlinesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Prasad Rao on 12-08-2020 12:46
 **/
@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Provides
    fun provideHeadlinesDao(database: NewsDatabase): HeadlinesDao {
        return database.headlinesDao()
    }

    @Singleton
    @Provides
    fun provideNewsDatabase(@ApplicationContext applicationContext: Context): NewsDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NewsDatabase::class.java,
            "news_database"
        ).build()
    }
}