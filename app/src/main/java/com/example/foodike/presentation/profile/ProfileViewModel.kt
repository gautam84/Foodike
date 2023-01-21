package com.example.foodike.presentation.profile

import androidx.lifecycle.ViewModel
import com.example.foodike.domain.repository.LoginRepository
import com.example.foodike.presentation.login.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.PerformLogout -> {
                repository.toggleLoginState()
                event.onClick()
            }
        }
    }
}