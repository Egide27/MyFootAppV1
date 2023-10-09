package com.example.myfootappv1.api.models

data class Player(
    val birthDate: String,
    val firtstName: String,
    val height: Double,
    val id: Int,
    val lastName: String,
    val team: Team,
    val weight: Double
)