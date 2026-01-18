package com.example.cricindia.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cricindia.ui.components.MatchCard
import com.example.cricindia.ui.viewmodel.CricketViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MatchListScreen(viewModel: CricketViewModel) {

    val matches = viewModel.matches.collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(
            isRefreshing = matches.loadState.refresh is LoadState.Loading
        ),
        onRefresh = { matches.refresh() }
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {

            items(matches.itemCount) { match ->
                val match = matches[match]
                match?.let {
                    MatchCard(it)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            when {
                matches.loadState.refresh is LoadState.Error -> {
                    item { Text("Failed to load matches") }
                }
                matches.loadState.append is LoadState.Loading -> {
                    item { CircularProgressIndicator() }
                }
            }
        }
    }
}
