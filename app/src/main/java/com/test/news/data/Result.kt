package com.test.news.data

/**
 * Created by Prasad Rao on 10-08-2020 19:35
 **/
sealed class Result<out T> {

  data class Success<R>(val data: R?) : Result<R>()

  data class Failure(val error: String) : Result<Nothing>()

  object Loading : Result<Nothing>()
}