package com.test.news.di

import com.test.news.NewsApplication
import com.test.news.data.source.local.room.dao.HeadlinesDao
import com.test.news.di.scope.ApplicationScoped
import dagger.Component
import retrofit2.Retrofit

/**
 * Created by Prasada Rao on 13/01/22 1:03 PM
 **/
@ApplicationScoped
@Component(modules = [RetrofitModule::class, RoomModule::class])
interface ApplicationComponent {

    fun getActivityComponent(): ActivityComponent

    fun getRetrofit(): Retrofit

    fun getHeadlinesDao(): HeadlinesDao

    fun inject(application: NewsApplication)
}