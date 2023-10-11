package com.example.myfootappv1.api.models

data class Player(
    var birthDate: String,
    var firtstName: String,
    var height: Double,
    var id: Int,
    var lastName: String,
    var team: Team?,
    var weight: Double
)