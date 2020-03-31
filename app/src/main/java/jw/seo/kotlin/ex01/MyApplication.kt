package jw.seo.kotlin.ex01

import android.app.Application
import jw.seo.kotlin.ex01.modules.diModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, diModule)
    }
}