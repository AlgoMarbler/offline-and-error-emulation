package com.example.sealed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sealedclasses.R

@Composable
internal fun Screen(viewState: ViewState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (viewState) {
            is ViewState.ScreenViewState -> NormalScreen(viewState)
            is ViewState.OfflineState -> OfflineScreen(viewState)
            is ViewState.ErrorState -> ErrorScreen(viewState)
        }
    }
}

@Composable
fun NormalScreen(screenData: ViewState.ScreenViewState) {
    Text(text = screenData.title)
    Image(
        painter = painterResource(id = R.drawable.epic_book), // Reference to epic_book.webp
        contentDescription = "Epic Book Image"
    )
    Text(text = screenData.confirmNormal)
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = screenData.onClickOffline) {
        Text(text = screenData.offlineButtonText)
    }
    Button(onClick = screenData.onClickError) {
        Text(text = screenData.errorButtonText)
    }
}

@Composable
fun OfflineScreen(screenData: ViewState.OfflineState) {
    Button(onClick = screenData.onClick) {
        Text(text = screenData.message)
    }
}

@Composable
fun ErrorScreen(screenData: ViewState.ErrorState) {
    Button(onClick = screenData.onClick) {
        Text(text = screenData.message)
    }
}
