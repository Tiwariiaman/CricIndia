package com.example.cricindia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cricindia.data.repository.CricketRepository

class CricketViewModel(
    repository: CricketRepository
): ViewModel(){
    private var lastRefreshTime = 0L
    val matches = repository.getMatches().cachedIn(viewModelScope)

    fun canRefresh(): Boolean {
        val now = System.currentTimeMillis()
        return if (now - lastRefreshTime > 30_000) { // 30 sec
            lastRefreshTime = now
            true
        } else {
            false
        }
    }
}