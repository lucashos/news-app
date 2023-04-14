package com.example.ctwnews

import android.app.Application
import com.example.ctwnews.core.coreModule
import com.example.ctwnews.data.dataModule
import com.example.ctwnews.feature.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CtwNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CtwNewsApplication)
            modules(coreModule, dataModule, featureModule)
        }
    }
}