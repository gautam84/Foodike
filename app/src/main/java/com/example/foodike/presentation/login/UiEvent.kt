package com.example.foodike.presentation.login

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
}