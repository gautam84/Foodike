package com.example.foodike.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.foodike.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


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