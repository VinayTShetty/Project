package com.example.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        val BASE_URL = "https://restcountries.com/v2/"

        /**
         * Fake API Response
         * https://restcountries.com/#api-endpoints-v3-all
         * @Get all Conuntries :- https://restcountries.com/v2/all
         */
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}