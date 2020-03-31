package jw.seo.kotlin.ex01.modules

import jw.seo.kotlin.ex01.net.ApiService
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "https://api.github.com"

var retrofitPart = module {
    single<ApiService> {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}

var diModule = listOf(retrofitPart)