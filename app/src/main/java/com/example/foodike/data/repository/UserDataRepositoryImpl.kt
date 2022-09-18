package com.example.foodike.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.foodike.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class UserDataRepositoryImpl(context: Context) : UserDataRepository {

    private object PreferencesKey {
        val likedRestaurants = stringSetPreferencesKey(name = "liked_restaurants")
    }


    private val dataStore = context.dataStore

    override suspend fun updateLikedRestaurant(restaurant: Set<String>) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.likedRestaurants] = restaurant
        }
    }

    override suspend fun getLikedRestaurants(): Flow<Set<String>> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.likedRestaurants] ?: setOf()
                onBoardingState
            }
    }

}