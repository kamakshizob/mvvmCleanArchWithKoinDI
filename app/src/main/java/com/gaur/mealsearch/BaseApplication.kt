package com.gaur.mealsearch

import android.app.Application
import com.gaur.mealsearch.diModules.useCaseModule
import com.gaur.mealsearch.diModules.viewModelModule
import org.koin.core.context.startKoin


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
           modules(useCaseModule, viewModelModule)
        }
    }
}