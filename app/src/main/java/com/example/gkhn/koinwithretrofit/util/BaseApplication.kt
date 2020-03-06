package com.example.gkhn.koinwithretrofit.util

import android.app.Application
import com.example.gkhn.koinwithretrofit.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(appModules)
        }
    }
}