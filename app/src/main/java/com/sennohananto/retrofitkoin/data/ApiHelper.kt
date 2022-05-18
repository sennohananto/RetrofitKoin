package com.sennohananto.retrofitkoin.data

class ApiHelper(private val apiService: ApiService) {
    suspend fun getPopularMovies() = apiService.getAllPopularMovies()
}