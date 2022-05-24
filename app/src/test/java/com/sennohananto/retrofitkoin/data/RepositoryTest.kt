package com.sennohananto.retrofitkoin.data

import com.sennohananto.retrofitkoin.data.pojo.PopularMoviesResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class RepositoryTest {
    //Collaborator
    private lateinit var apiService: ApiService
    private lateinit var apiHelper: ApiHelper
    //private lateinit var dbHelper: DbHelper

    //System Under Test
    private lateinit var repository: Repository

    @Before //Initialize, Mocking, Inject
    fun setUp() {
        //Mockk -> Lib membantu mocking
        //Mockito
        //PowerMock
        //EasyMock
        apiService = mockk()
        //dbHelper = mockk()
        apiHelper = ApiHelper(apiService)
        repository = Repository(apiHelper /*, dbHelper*/)
    }

    @Test
    fun getPopularMovies():Unit = runBlocking {
        //Given
        val responseMovies = mockk<PopularMoviesResponse>()

        every {
            runBlocking {
                apiService.getAllPopularMovies()
            }
        } returns responseMovies

        //When
        repository.getPopularMovies()

        //Then
        verify {
            runBlocking { apiService.getAllPopularMovies() }
        }
    }
}