package com.test.news.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.news.data.source.local.room.entity.DatabaseHeadline

/**
 * Created by Prasad Rao on 12-08-2020 12:37
 **/
@Dao
interface HeadlinesDao {

  @Query("SELECT * FROM headline WHERE page = :page LIMIT :pageSize")
  suspend fun fetchHeadlines(page: Int, pageSize: Int): List<DatabaseHeadline>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertHeadlines(headlines: List<DatabaseHeadline>)
}