package com.example.foodike.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.foodike.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    private val _email = mutableStateOf(
        FoodikeTextFieldState(
            hint = "Enter email or phone number"
        )
    )
    val email: State<FoodikeTextFieldState> = _email

    private val _password = mutableStateOf(
        FoodikeTextFieldState(
            hint = "Password"
        )
    )
    val password: State<FoodikeTextFieldState> = _password



    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredEmail -> {
                _email.value = email.value.copy(
                    text = event.value
                )

            }
            is LoginEvent.EnteredPassword -> {
                _password.value = password.value.copy(
                    text = event.value
                )
            }

            is LoginEvent.PerformLogin -> {

                if (email.value.text == "abcxyz@gmail.com" && password.value.text == "abcdef"){
                    repository.toggleLoginState()
                    event.onClick()
                }

            }


        }


    }


}