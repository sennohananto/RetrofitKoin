package com.sennohananto.retrofitkoin.di

import com.sennohananto.retrofitkoin.data.ApiHelper
import com.sennohananto.retrofitkoin.data.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Container -> Menampung
//Menampung Instance

val BASE_URL = "https://api.themoviedb.org/3/"
val networkModule = module {
    //Membuat instance OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url.newBuilder()
                    .addQueryParameter("api_key", "554481f2801f7c87295993b4a632762a")
                    .build()

                val request = original.newBuilder().url(url).build()
                chain.proceed(request)
            }
            .build()
    }

    //Membuat instance Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    //Membuat Instance ApiService
    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    //Membuat Instance ApiHelper
    singleOf(::ApiHelper)

//    single{
//        ApiHelper(get())
//    }
}

