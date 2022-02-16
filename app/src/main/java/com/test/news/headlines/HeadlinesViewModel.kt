package com.test.news.headlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.test.news.data.Result
import com.test.news.data.repository.NewsRepository
import com.test.news.model.Headline
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 20:06
 **/
@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    fun observeHeadlines(page: Int, pageSize: Int): LiveData<Result<List<Headline>>> = liveData {
        emit(Result.Loading)
        emit(newsRepository.fetchHeadlines(page, pageSize))
    }

    fun observeHeadlines(): Flow<PagingData<Headline>> {
        return newsRepository.fetchPagingHeadlines().cachedIn(viewModelScope)
    }
}