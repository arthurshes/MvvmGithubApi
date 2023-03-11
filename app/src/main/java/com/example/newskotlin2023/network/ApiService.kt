package com.example.newskotlin2023.network

import com.example.newskotlin2023.Models.RepoList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q")query: String):RepoList
}