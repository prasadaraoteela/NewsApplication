package com.test.news.di

import com.test.news.headlines.HeadlinesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Prasada Rao on 13/01/22 4:46 PM
 **/
@Module(includes = [RetrofitModule::class, RoomModule::class])
abstract class ApplicationModule {

  @ContributesAndroidInjector(modules = [DataModule::class])
  abstract fun contributeToHeadlinesActivity(): HeadlinesActivity
}