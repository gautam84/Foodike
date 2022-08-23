package com.example.foodike.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun saveLoginState(completed: Boolean)
    fun readLoginState(): Flow<Boolean>
}