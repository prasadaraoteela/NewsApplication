package com.test.news.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.news.data.repository.NewsRepository
import javax.inject.Inject

/**
 * Created by Prasada Rao on 13/01/22 1:23 PM
 **/
class HeadlinesViewModelFactory @Inject constructor(
  private val repository: NewsRepository
) : ViewModelProvider.Factory {
  @SuppressWarnings("unchecked")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(HeadlinesViewModel::class.java)) {
      return HeadlinesViewModel(repository) as T
    }
    throw IllegalStateException("Unknown ViewModel class")
  }
}