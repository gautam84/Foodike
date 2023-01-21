package com.example.foodike.data.repository

import android.content.Context
import com.example.foodike.domain.repository.LoginRepository


class LoginRepositoryImpl(context: Context) : LoginRepository {

    private val prefs = context.getSharedPreferences(LOGIN_STATE, Context.MODE_PRIVATE)
    private val isUserLoggedIn = prefs.getBoolean(IS_USER_LOGGED_IN, false)


    companion object {
        const val LOGIN_STATE = "user_login_state"
        const val IS_USER_LOGGED_IN = "is_user_logged_in"
    }

    override fun readLoginState(): Boolean {
        return prefs.getBoolean(IS_USER_LOGGED_IN, false)
    }

    override fun toggleLoginState() {
        prefs.edit().putBoolean(IS_USER_LOGGED_IN, !isUserLoggedIn).apply()
    }


}