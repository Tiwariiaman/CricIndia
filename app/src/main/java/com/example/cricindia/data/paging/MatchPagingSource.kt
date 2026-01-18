package com.example.cricindia.data.paging

import android.util.Log.e
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cricindia.data.model.Match
import com.example.cricindia.data.remote.CricketApi



class MatchPagingSource(
    private val api: CricketApi,
    private val apiKey: String
) : PagingSource<Int, Match>() {
    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Match> {
        return try {
            val page = params.key ?: 0
            val response = api.getMatches(apiKey, page)

            val matches = response.data.map { dto ->
                val team1 = dto.score?.getOrNull(0)
                val team2 = dto.score?.getOrNull(1)

                Match(
                    id = dto.id,
                    title = dto.name,
                    status = dto.status,
                    venue = dto.venue,
                    team1Scrore = team1?.let {
                        "${it.runs}/${it.wickets} (${it.overs})"
                    },
                    // FIXED LINE:
                    team2Scrore = team2?.let {
                        "${it.runs}/${it.wickets} (${it.overs})"
                    }
                )
            }

            LoadResult.Page(
                data = matches,
                prevKey = if (page == 0) null else page - 10,
                nextKey = page + 10
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

//class MatchPagingSource(
//    private val api: CricketApi,
//    private val apikey: String
//) : PagingSource<Int, Match>() {
//
//    override fun getRefreshKey(
//        state: PagingState<Int, Match>
//    ): Int? = null
//
//    override suspend fun load(
//        params: LoadParams<Int>
//    ): LoadResult<Int, Match> {
//
//        // 🔴 BLOCK APPEND CALLS COMPLETELY
//        if (params is LoadParams.Append) {
//            return LoadResult.Page(
//                data = emptyList(),
//                prevKey = null,
//                nextKey = null
//            )
//        }
//
//        return try {
//            val response = api.getMatches(apikey, 0)
//
//            val matches = response.data
//                ?.map { dto ->
//                    val team1 = dto.score?.getOrNull(0)
//                    val team2 = dto.score?.getOrNull(1)
//
//                    Match(
//                        id = dto.id,
//                        title = dto.name,
//                        status = dto.status,
//                        venue = dto.venue,
//                        team1Scrore = team1?.let {
//                            "${it.runs}/${it.wickets} (${it.overs})"
//                        },
//                        team2Scrore = team2?.let {
//                            "${it.runs}/${it.wickets} (${it.overs})"
//                        }
//                    )
//                }
//                ?: emptyList()   // 🔴 NULL SAFETY
//
//            LoadResult.Page(
//                data = matches,
//                prevKey = null,
//                nextKey = null
//            )
//
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}
