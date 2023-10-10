package com.example.myfootappv1.api

import com.example.myfootappv1.api.models.Player
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerApi {

    @GET("players/{id}")
    suspend fun findById(@Path("id") id : Int) : Player
}