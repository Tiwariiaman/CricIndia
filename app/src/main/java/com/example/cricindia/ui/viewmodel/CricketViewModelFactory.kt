package com.example.cricindia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cricindia.data.repository.CricketRepository

class CricketViewModelFactory(
    private val repository: CricketRepository
): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CricketViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CricketViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}