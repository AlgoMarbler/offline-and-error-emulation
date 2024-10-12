package com.example.sealed

sealed class ViewState(
    open val moveNextPage: () -> Unit
) {
    data class ScreenViewState(
        val title: String,
        val confirmNormal: String,
        val offlineButtonText: String,
        val errorButtonText: String,
        val onClickOffline: () -> Unit,
        val onClickError: () -> Unit,
        override val moveNextPage: () -> Unit
    ) : ViewState(moveNextPage)

    data class OfflineState(
        val message: String,
        val onClick: () -> Unit,
        override val moveNextPage: () -> Unit
    ) : ViewState(moveNextPage)

    data class ErrorState(
        val message: String,
        val onClick: () -> Unit,
        override val moveNextPage: () -> Unit
    ) : ViewState(moveNextPage)
}
