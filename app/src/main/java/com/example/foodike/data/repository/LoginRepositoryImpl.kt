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

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "login_pref")

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
//
//    private object PreferencesKey {
//        val onBoardingKey = booleanPreferencesKey(name = "on_login_completed")
//    }
//
//    private val dataStore = context.dataStore
//
//    override suspend fun saveLoginState(completed: Boolean) {
//        dataStore.edit { preferences ->
//            preferences[PreferencesKey.onBoardingKey] = completed
//        }
//    }
//
//    override fun readLoginState(): Flow<Boolean> {
//        return dataStore.data
//            .catch { exception ->
//                if (exception is IOException) {
//                    emit(emptyPreferences())
//                } else {
//                    throw exception
//                }
//            }
//            .map { preferences ->
//                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
//                onBoardingState
//            }
//    }

}