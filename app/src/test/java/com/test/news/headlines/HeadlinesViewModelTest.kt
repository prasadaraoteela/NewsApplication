package com.test.news.headlines

import com.test.news.data.Result
import com.test.news.data.repository.NewsRepository
import com.test.news.data.source.network.convertToDomainEntity
import com.test.news.data.source.network.dto.NetworkNews
import com.test.news.model.Headline
import com.test.news.util.CoroutineTestRule
import com.test.news.util.TestResourceReader
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Prasad Rao on 10-08-2020 20:44
 */
class HeadlinesViewModelTest {

  lateinit var headlinesViewModel: HeadlinesViewModel
  lateinit var mockRepository: NewsRepository

  @get:Rule val coroutineTestRule = CoroutineTestRule()

  @OptIn(ExperimentalCoroutinesApi::class)
  @Before
  fun setUp() {
    mockRepository = FakeNewsRepository()
  }

  @ExperimentalCoroutinesApi
  @Test
  fun observeHeadlines_success() = runTest {
    // Given
    headlinesViewModel = HeadlinesViewModel(mockRepository, UnconfinedTestDispatcher(testScheduler))
    val newsResult: NetworkNews? =
      TestResourceReader.readNetworkNewsResponse("headlines_success_response.json")

    val headlines = newsResult?.articles?.map { it.convertToDomainEntity(1) } ?: emptyList()
    // When
    val result: Result.Success<List<Headline>> =
      headlinesViewModel.observeHeadlines(1, 2).drop(1)
        .first() as Result.Success<List<Headline>>
    // Then
    assertThat(result.data?.size, IsEqual(headlines.size))
    assertThat(result.data, IsEqual(headlines))
  }

  //@ExperimentalCoroutinesApi
  //@Test
  //fun observeHeadlines_failure() = runTest {
  //  // Given
  //  headlinesViewModel = HeadlinesViewModel(mockRepository, UnconfinedTestDispatcher(testScheduler))
  //  // When
  //  val result: Result.Failure =
  //    headlinesViewModel.observeHeadlines(1, 2)
  //      .drop(1).first() as Result.Failure
  //  println(result)
  //  // Then
  //  assertThat(result.error, IsEqual(newsResult?.message))
  //}
}