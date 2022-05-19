package com.test.news.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Created by Prasada Rao on 10/04/22 6:55 PM
 **/
@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTestRule : TestWatcher() {

  private val testDispatcher = UnconfinedTestDispatcher()

  override fun starting(description: Description?) {
    super.starting(description)
    Dispatchers.setMain(testDispatcher)
  }

  override fun finished(description: Description?) {
    Dispatchers.resetMain()
    testDispatcher.cancel()
    super.finished(description)
  }
}