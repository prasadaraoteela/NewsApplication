package com.test.news.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.test.news.data.Result
import com.test.news.data.repository.NewsRepository
import com.test.news.di.qualifier.IO
import com.test.news.model.Headline
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 20:06
 **/
@HiltViewModel
class HeadlinesViewModel @Inject constructor(
  private val newsRepository: NewsRepository,
  @IO private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

  fun observeHeadlines(page: Int, pageSize: Int): StateFlow<Result<List<Headline>>> = flow {
    emit(newsRepository.fetchHeadlines(page, pageSize))
  }.stateIn(viewModelScope, SharingStarted.Eagerly, Result.Loading)

  fun observeHeadlines(): Flow<PagingData<Headline>> {
    return newsRepository.fetchPagingHeadlines().cachedIn(viewModelScope)
  }
}