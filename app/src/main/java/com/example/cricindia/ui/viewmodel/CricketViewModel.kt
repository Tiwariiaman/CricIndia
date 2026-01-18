package com.example.cricindia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cricindia.data.repository.CricketRepository

class CricketViewModel(
    repository: CricketRepository
): ViewModel(){
    val matches = repository.getMatches().cachedIn(viewModelScope)
}