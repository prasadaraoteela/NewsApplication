package com.test.news.di

import android.content.Context
import androidx.room.Room
import com.test.news.data.source.local.room.NewsDatabase
import com.test.news.data.source.local.room.dao.HeadlinesDao
import com.test.news.di.scope.ApplicationScoped
import dagger.Module
import dagger.Provides

/**
 * Created by Prasad Rao on 12-08-2020 12:46
 **/
@Module
class RoomModule(
    private val applicationContext: Context
) {

    @Provides
    fun provideHeadlinesDao(database: NewsDatabase): HeadlinesDao {
        return database.headlinesDao()
    }

    @ApplicationScoped
    @Provides
    fun provideNewsDatabase(): NewsDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NewsDatabase::class.java,
            "news_database"
        ).build()
    }
}