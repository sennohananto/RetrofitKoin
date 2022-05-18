package com.sennohananto.retrofitkoin

import android.app.Application
import com.sennohananto.retrofitkoin.di.networkModule
import com.sennohananto.retrofitkoin.di.repositoryModule
import com.sennohananto.retrofitkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RetrofitKoin: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()

            androidContext(this@RetrofitKoin)

            modules(
                listOf(networkModule, repositoryModule, viewModelModule)
            )
        }
    }
}