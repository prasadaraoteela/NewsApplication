package com.test.news.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.news.data.source.local.room.dao.HeadlinesDao
import com.test.news.data.source.local.room.entity.DatabaseHeadline

/**
 * Created by Prasad Rao on 12-08-2020 12:43
 **/
@Database(
  entities = [DatabaseHeadline::class],
  version = 1,
  exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
  abstract fun headlinesDao(): HeadlinesDao
}