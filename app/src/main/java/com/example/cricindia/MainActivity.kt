package com.example.cricindia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cricindia.data.remote.RetrofitClient
import com.example.cricindia.data.repository.CricketRepositoryImpl
import com.example.cricindia.ui.screens.MatchListScreen
import com.example.cricindia.ui.theme.CricIndiaTheme
import com.example.cricindia.ui.viewmodel.CricketViewModel
import com.example.cricindia.ui.viewmodel.CricketViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = CricketRepositoryImpl(api = RetrofitClient.api)
        val viewModel = ViewModelProvider(this, CricketViewModelFactory(repository))[CricketViewModel::class.java]

        setContent {
            CricIndiaTheme {
                MatchListScreen(viewModel = viewModel)
            }
        }
    }
}