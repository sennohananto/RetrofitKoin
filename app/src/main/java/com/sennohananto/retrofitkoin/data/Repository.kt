package com.sennohananto.retrofitkoin.data

class Repository(private val apiHelper: ApiHelper /*private val dbHelper: DbHelper*/) {
    suspend fun getPopularMovies() = apiHelper.getPopularMovies()

}