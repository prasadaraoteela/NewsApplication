package com.test.news.di

import com.test.news.di.scope.ActivityScoped
import com.test.news.headlines.HeadlinesActivity
import com.test.news.headlines.HeadlinesViewModelFactory
import dagger.Subcomponent

/**
 * Created by Prasada Rao on 13/01/22 1:18 PM
 **/
@ActivityScoped
@Subcomponent(modules = [DataModule::class])
interface ActivityComponent {

    fun getHeadlinesViewModelFactory(): HeadlinesViewModelFactory

    fun inject(activity: HeadlinesActivity)
}