package com.example.foodike.presentation.profile

import com.example.foodike.presentation.login.LoginEvent


sealed class ProfileEvent {
    data class PerformLogout(val onClick: () -> Unit) : ProfileEvent()
}