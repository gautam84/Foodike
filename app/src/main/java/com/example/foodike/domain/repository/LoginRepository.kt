package com.example.foodike.domain.repository

interface LoginRepository {
    fun readLoginState(): Boolean
    fun toggleLoginState()
}