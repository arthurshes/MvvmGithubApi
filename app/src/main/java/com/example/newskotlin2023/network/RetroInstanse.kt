package com.example.newskotlin2023.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstanse {

    companion object{
        val BASE_URL="https://api.github.com/search/"

        fun getRetroInstanse():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}