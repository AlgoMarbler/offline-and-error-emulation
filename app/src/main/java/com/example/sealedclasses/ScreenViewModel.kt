package com.example.sealed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {
    var viewState: ViewState by mutableStateOf(
        ViewState.ScreenViewState(
            title = "Here is an epic book",
            confirmNormal = "If you're seeing this page, everything is working!",
            offlineButtonText = "Click to go offline",
            errorButtonText = "Click to experience errors :)",
            onClickOffline = ::changeToOffline,
            onClickError = ::changeToError,
            moveNextPage = ::changeToNormal
        )
    )

    private fun changeToOffline() {
        viewState = ViewState.OfflineState(
            message = "You are now offline",
            onClick = ::changeToNormal,
            moveNextPage = ::changeToNormal
        )
    }

    private fun changeToError() {
        viewState = ViewState.ErrorState(
            message = "An error occurred!",
            onClick = ::changeToNormal,
            moveNextPage = ::changeToNormal
        )
    }

    private fun changeToNormal() {
        viewState = ViewState.ScreenViewState(
            title = "Here is an epic book",
            confirmNormal = "If you're seeing this page, everything is working!",
            offlineButtonText = "Click to go offline",
            errorButtonText = "Click to experience errors :)",
            onClickOffline = ::changeToOffline,
            onClickError = ::changeToError,
            moveNextPage = ::changeToNormal
        )
    }

}
