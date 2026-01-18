package com.example.cricindia.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cricindia.data.model.Match
import com.example.cricindia.data.paging.MatchPagingSource
import com.example.cricindia.data.remote.CricketApi
import kotlinx.coroutines.flow.Flow

class CricketRepositoryImpl (
    private val api: CricketApi
): CricketRepository
{
    override fun getMatches(): Flow<PagingData<Match>>{
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                MatchPagingSource(api, "ec867e2b-cdb2-4d04-aa14-a8997158a11c")
            }
        ).flow
    }
}