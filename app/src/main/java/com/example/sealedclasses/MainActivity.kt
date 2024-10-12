package com.example.sealedclasses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.sealed.Screen
import com.example.sealed.ScreenViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen(viewState = viewModel.viewState)
        }
    }
}
