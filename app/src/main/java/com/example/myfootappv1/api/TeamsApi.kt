package com.example.myfootappv1.api

import com.example.myfootappv1.api.models.Team
import retrofit2.http.GET

interface TeamsApi {
    @GET("teams")
    suspend fun getAll() : List<Team>
}