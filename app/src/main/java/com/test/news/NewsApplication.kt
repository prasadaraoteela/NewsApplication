package com.test.news

import android.app.Application
import com.test.news.di.ApplicationComponent
import com.test.news.di.DaggerApplicationComponent
import com.test.news.di.RoomModule

/**
 * Created by Prasad Rao on 10-08-2020 20:28
 **/
class NewsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .roomModule(RoomModule(this))
            .build()
        applicationComponent.inject(this)
    }
}