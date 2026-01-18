package com.example.cricindia.data.remote

data class CricketResponse(
    val data: List<MatchDTO>,
    val status: String,
)

data class MatchDTO(
    val id: String,
    val name: String,
    val status: String,
    val venue: String,
    val score:List<ScoreDto>?
)
data class ScoreDto(
    val inning: String,
    val runs: String,
    val wickets: Int,
    val overs: String
)