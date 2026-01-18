package com.example.cricindia.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CricketApi {
    @GET("v1/currentMatches")
    suspend fun getMatches(
        @Query("apikey") apikey: String,
        @Query("offset") offset: Int,
    ): CricketResponse
}