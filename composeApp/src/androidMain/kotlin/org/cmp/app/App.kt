package org.cmp.app

import android.app.Application
import org.cmp.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin { koinContext ->
            koinContext.androidContext(this@App)
        }
    }

}