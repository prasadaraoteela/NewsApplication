package com.test.news

import android.app.Application
import com.test.news.di.ApplicationComponent
import com.test.news.di.DaggerApplicationComponent
import com.test.news.di.RoomModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Prasad Rao on 10-08-2020 20:28
 **/
class NewsApplication : Application(), HasAndroidInjector {

  @Inject lateinit var injector: DispatchingAndroidInjector<Any>

  lateinit var applicationComponent: ApplicationComponent
    private set

  override fun onCreate() {
    super.onCreate()

    applicationComponent = DaggerApplicationComponent.builder()
      .roomModule(RoomModule(this))
      .build()
    applicationComponent.inject(this)
  }

  override fun androidInjector(): AndroidInjector<Any> = injector
}