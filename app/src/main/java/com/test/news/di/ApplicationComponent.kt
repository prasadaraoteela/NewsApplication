package com.test.news.di

import com.test.news.NewsApplication
import com.test.news.di.scope.ApplicationScoped
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by Prasada Rao on 13/01/22 1:03 PM
 **/
@ApplicationScoped
@Component(
  modules = [
    AndroidInjectionModule::class, ApplicationModule::class
  ]
)
interface ApplicationComponent : AndroidInjector<NewsApplication>