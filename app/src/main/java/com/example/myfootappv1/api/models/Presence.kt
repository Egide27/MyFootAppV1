package com.example.myfootappv1.api.models

data class Presence(
    val comment: String,
    val player: Player,
    val present: Boolean,
    val session: Session
)