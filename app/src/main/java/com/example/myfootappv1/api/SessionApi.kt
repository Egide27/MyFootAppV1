package com.example.myfootappv1.api

import com.example.myfootappv1.api.models.Session
import retrofit2.http.GET

interface SessionApi {
    @GET("sessions")
    suspend fun getAll() : List<Session>
}