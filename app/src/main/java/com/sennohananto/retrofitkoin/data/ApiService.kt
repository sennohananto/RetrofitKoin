package com.sennohananto.retrofitkoin.data

import com.sennohananto.retrofitkoin.data.pojo.PopularMoviesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular")
    suspend fun getAllPopularMovies(): PopularMoviesResponse
}