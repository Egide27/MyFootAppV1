package com.example.myfootappv1.api

import com.example.myfootappv1.api.models.Player
import com.example.myfootappv1.api.models.Team
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsApi {
    @GET("teams")
    suspend fun getAll() : List<Team>

    @GET("teams/{id}/players")
    suspend fun getPlayersByTeam(@Path("id") id : Int) : List<Player>
}