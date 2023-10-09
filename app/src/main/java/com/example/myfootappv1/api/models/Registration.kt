package com.example.myfootappv1.api.models

data class Registration(
    val active: Boolean,
    val id: Int,
    val player: Player,
    val registrationDate: String,
    val team: Team,
    val validate: Boolean
)