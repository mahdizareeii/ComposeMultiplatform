package org.cmp.app

import android.app.Application
import org.cmp.app.di.initKoin
import org.koin.android.ext.koin.androidContext

//this class can separate from this shared module and just include the shared cmp module in the own module
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin { koinContext ->
            koinContext.androidContext(this@App)
        }
    }

}