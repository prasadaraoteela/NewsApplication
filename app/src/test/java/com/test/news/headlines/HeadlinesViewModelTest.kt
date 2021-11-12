package com.test.news.headlines

import com.test.news.data.Result
import com.test.news.data.repository.NewsRepository
import com.test.news.data.source.network.dto.NetworkNews
import com.test.news.getOrAwaitValue
import com.test.news.model.Headline
import com.test.news.util.TestResourceReader
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

/**
 * Created by Prasad Rao on 10-08-2020 20:44
 */
@RunWith(RobolectricTestRunner::class)
class HeadlinesViewModelTest {

    lateinit var headlinesViewModel: HeadlinesViewModel
    lateinit var mockRepository: NewsRepository

    @Before
    fun setUp() {
        mockRepository = mock(NewsRepository::class.java)
        headlinesViewModel = HeadlinesViewModel(mockRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun observeHeadlines_success() = runBlockingTest {
        // Given
        val headlines = TestResourceReader.readHeadlines("headlines_success_response.json")
        `when`(mockRepository.fetchHeadlines(anyInt(), anyInt())).thenReturn(
            Result.Success(
                headlines
            )
        )
        // When
        val result: Result.Success<List<Headline>> =
            headlinesViewModel.observeHeadlines(1, 2)
                .getOrAwaitValue() as Result.Success<List<Headline>>
        println(result)
        // Then
        assertThat(result.data?.size, IsEqual(headlines.size))
        assertThat(result.data, IsEqual(headlines))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun observeHeadlines_failure() = runBlockingTest {
        // Given
        val newsResult: NetworkNews? = TestResourceReader.readNetworkNewsResponse("headlines_apikey_failure_response.json")
        println(newsResult)
        `when`(mockRepository.fetchHeadlines(anyInt(), anyInt()))
            .thenReturn(Result.Failure(newsResult?.message ?: ""))
        // When
        val result: Result.Failure =
            headlinesViewModel.observeHeadlines(1, 2)
                .getOrAwaitValue() as Result.Failure
        println(result)
        // Then
        assertThat(result.error, IsEqual(newsResult?.message))
    }
}