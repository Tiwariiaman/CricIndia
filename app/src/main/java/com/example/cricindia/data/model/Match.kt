package com.example.cricindia.data.model

data class Match(
    val id: String,
    val title: String,
    val status: String,
    val venue: String,
    val team1Scrore: String?,
    val team2Scrore: String?,
)