package com.example.myfootappv1.api.models

data class Session(
    val coach: Coach,
    val date: String,
    val duration: Int,
    val sessionType: String
)