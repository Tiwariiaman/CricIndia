package com.example.cricindia.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cricindia.ui.components.MatchCard
import com.example.cricindia.ui.viewmodel.CricketViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchListScreen(viewModel: CricketViewModel) {

    val matches = viewModel.matches.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cric India",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { paddingValues ->
        SwipeRefresh(
            state = rememberSwipeRefreshState(
                isRefreshing = matches.loadState.refresh is LoadState.Loading
            ),
            onRefresh = {
                if (viewModel.canRefresh()) {
                    matches.refresh()
                }
            },
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ){
            LazyColumn(modifier = Modifier.padding(16.dp).fillMaxSize()) {

                items(
                    count = minOf(matches.itemCount, 10)
                ) { index ->
                    matches[index]?.let {
                        MatchCard(it)
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
}
