package com.test.news.di

import com.test.news.di.qualifier.IO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Prasada Rao on 10/04/22 12:52 PM
 **/
@InstallIn(ViewModelComponent::class)
@Module
object DispatcherModule {

  @IO
  @Provides
  fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}