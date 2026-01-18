package com.example.cricindia.data.repository

import androidx.paging.PagingData
import com.example.cricindia.data.model.Match
import kotlinx.coroutines.flow.Flow

interface CricketRepository {
    fun getMatches(): Flow<PagingData<Match>>
}